package com.jinse.blog.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.UserAndInfor;
import com.jinse.blog.pojo.UserClasses;
import com.jinse.blog.service.PictureService;
import com.jinse.blog.service.ProvinceService;
import com.jinse.blog.service.UserService;
import com.jinse.blog.utils.AvatarUtil;
import com.jinse.blog.utils.ConstantsUtil;
import com.jinse.blog.utils.MD5Util;
import com.jinse.blog.utils.SavePicture;
import com.jinse.blog.utils.SpringUtil;
import com.jinse.blog.utils.UserUtil;
import com.jinse.blog.vos.ResultVO;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private PictureService pictureService;
	@Autowired
	private ProvinceService provinceService;
	
	
	// 注册
	@RequestMapping("/signup")
	public String signupIndex(Model model) throws Exception {
		return "user/signup";
	}

	// 登录
	@RequestMapping("/login")
	public String signinIndex(Model model) throws Exception {
		return "user/login";
	}

	// 进行注册
	@RequestMapping(value = "/savaUser", method = RequestMethod.POST)
	public String savaUser(Model model, HttpServletRequest request, User user) throws Exception {
		logger.info("用户注册" + user);

		User userRes = userService.findUserByUsername(user.getUsername());
		if (userRes != null) {
			return "user/signup";
		}
		user.setPassword(MD5Util.MD5(user.getPassword()));
		user = UserUtil.initUser(user);
		userService.saveUserAndReturnId(user);
		
		
		return "user/login";
	}

	// 进行登录
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String loginUser(Model model, HttpServletRequest request, User user) throws Exception {
	

		ResultVO result = new ResultVO();
		user.setPassword(MD5Util.MD5(user.getPassword()));
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
		token.setRememberMe(true);
		Subject currentUser = SecurityUtils.getSubject();
		boolean loginSuccess = true;
		Map<String, String> fieldErrors = new HashMap<String, String>();
		try {
			currentUser.login(token);
		} catch (UnknownAccountException ex) {
			loginSuccess = false;
			fieldErrors.put("userName", "login.input.username");
			result.setFieldErrors(fieldErrors);
			result.setMessage(ConstantsUtil.AJAX_SAVE_MESSAGE_FAIL);
		} catch (IncorrectCredentialsException ex) {
			loginSuccess = false;
			fieldErrors.put("password", "login.input.pwd");
		} catch (AuthenticationException e) {
			loginSuccess = false;
			fieldErrors.put("exception", "login.login.error");
		}
		if (loginSuccess) {
			UserClasses sessionUser = userService.findByUser(user);
			SpringUtil.setSession(ConstantsUtil.STRING_CURRENT_USER, sessionUser);
			SpringUtil.setSession(ConstantsUtil.STRING_USER_NAME, sessionUser.getUsername());

		} else {
			result.setCode(ConstantsUtil.VALIDATION_ERROR);
			result.setFieldErrors(fieldErrors);
			result.setMessage(ConstantsUtil.AJAX_LOGIN_MESSAGE_FAIL);
			return "user/login";
		}
		return "photo";
		/* request.getSession().setAttribute("username", user.getUsername()); */
	}

	// 个人设置
	@RequestMapping(value = "/information")
	public String information(Model model, HttpServletRequest request) throws Exception {
		if (SpringUtil.getCurrentUser() != null && SpringUtil.getCurrentUser().getUserId() != null) {
			Integer userId = SpringUtil.getCurrentUser().getUserId();
			User user = userService.findUserByUserId(userId);
			
			model.addAttribute("user", user);
			SpringUtil.setSession(ConstantsUtil.STRING_CURRENT_USER, user);
			SpringUtil.setSession(ConstantsUtil.STRING_USER_NAME, user.getUsername());
			/*
			 * if(user.getCityId() != null && user.getCityId() != "") { Province province =
			 * provinceService.findProIdList(user.getCityId());
			 * model.addAttribute("province",province); }
			 */
		} else {
			return "redirect:login";
		}
		return "user/information";
	}

	// 退出
	@RequestMapping("/logout")
	public String logout() {
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		SpringUtil.setSession(ConstantsUtil.STRING_CURRENT_USER, null);
		SpringUtil.setSession(ConstantsUtil.STRING_USER_NAME, null);
		return "redirect:login";
	}

	// 更新头像
	@RequestMapping(value = "/uploadAvatar", method = RequestMethod.POST)
	@ResponseBody
	public User uploadAvatar(Model model, HttpServletRequest request,
			@RequestParam("avatarFile") MultipartFile avatarFile) throws Exception {
		logger.info("add头像开始" + avatarFile);
		Integer userId = SpringUtil.getCurrentUser().getUserId();
		// 保存avatar
		// String imgSrc = avatarFile.getOriginalFilename();
		String avatarUrl = "http://p1vkce34m.bkt.clouddn.com/image/jpg/avatar/timg.jpg";

		// 存到工作空间
		String originalFilename = avatarFile.getOriginalFilename();
		if (avatarFile != null && originalFilename != null && originalFilename.length() > 0) {
			// 存储图片的位置
			String pic_path = request.getSession().getServletContext().getRealPath("static/img") + "/";
			// 为文件名重新编码
			String newFilename = "avatar" + originalFilename.substring(originalFilename.lastIndexOf("."));
			String realName = pic_path + newFilename;
			File newFile = new File(realName);
			// 将数据写入到指定位置即可
			avatarFile.transferTo(newFile);

			// 压缩
			String outFilePath = AvatarUtil.createImgThumbnail(avatarFile, realName);
			// 上传到七牛一年
			avatarUrl = SavePicture.savaAvatar(outFilePath);
		}
		// 更新url
		User user = new User();
		user.setUserId(userId);
		user.setAvatarUrl(avatarUrl);
		userService.updateAvatarUrlByUserId(user);

		return user;
	}

	// 更新信息
	@RequestMapping(value = "/uploadInfor", method = RequestMethod.POST)
	public String uploadInfor(Model model, HttpServletRequest request, User user, String birth) throws Exception {
		logger.info(user.getUsername());
		UserUtil.formatAddress(user);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(birth !=null && birth.length() > 0) {
			Date birthday = sdf.parse(birth);
			user.setBirthday(birthday);
		}
		Integer userId = SpringUtil.getCurrentUser().getUserId();
		user.setUserId(userId);
		//设置city
		provinceService.setCityByUserId(user);
		userService.updateUserByUserId(user);
		return "redirect:information";
	}

/*	// 其他用户主页
	@RequestMapping(value = "/myPhoto/{userId}")
	public String myPhotoes(@PathVariable("userId") Integer userId, Model model, HttpServletRequest request, User user) throws Exception {
		logger.info("跳转到用户主页");
		user = pictureService.findAllPictureByUserId(userId);
		UserAndInfor userAndInfor = UserUtil.userToUserAndInfor(user);
		model.addAttribute("user", userAndInfor);
		return "home/userpage";
	}*/

}
