package com.jinse.blog.utils;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.jinse.blog.pojo.User;
import com.jinse.blog.pojo.UserAndInfor;
import com.jinse.blog.service.ProvinceService;

public class UserUtil {

	public static User initUser(User user) {
		user.setCreateAt(new Date());
		user.setFollowerNumber(0);
		user.setFollowingNumber(0);
		user.setAvatarUrl("http://p1vkce34m.bkt.clouddn.com/image/jpg/avatar/timg.jpg");
		return user;
	}

	public static void formatAddress(User user) {
		String provinceId = user.getProvinceId();
		String cityId = user.getCityId();
		String villageId = user.getVillageId();

		user.setProvinceId(formatToNull(provinceId));
		user.setCityId(formatToNull(cityId));
		user.setVillageId(formatToNull(villageId));
	}

	private static String formatToNull(String id) {
		return id.equals("请选择") ? null : id;
	}

	public static UserAndInfor userToUserAndInfor(User user) {
		UserAndInfor userAndInfor = new UserAndInfor();
		userAndInfor.setAddress(user.getAddress());
		userAndInfor.setAvatarUrl(user.getAvatarUrl());
		userAndInfor.setBirthday(user.getBirthday());
		userAndInfor.setBlog(user.getBlog());
		userAndInfor.setCityId(user.getCityId());
		userAndInfor.setCreateAt(user.getCreateAt());
		userAndInfor.setEmail(user.getEmail());
		userAndInfor.setFollowerNumber(user.getFollowerNumber());
		userAndInfor.setFollowingNumber(user.getFollowingNumber());
		userAndInfor.setGender(user.getGender());
		userAndInfor.setMoney(user.getMoney());
		userAndInfor.setPassword(user.getPassword());
		userAndInfor.setPhone(user.getPhone());
		userAndInfor.setProvinceId(user.getProvinceId());
		userAndInfor.setRoleId(user.getRoleId());
		userAndInfor.setSignatur(user.getSignatur());
		userAndInfor.setUserId(user.getUserId());
		userAndInfor.setUsername(user.getUsername());
		userAndInfor.setVillageId(user.getVillageId());
		userAndInfor.setBlogList(user.getBlogList());
		return userAndInfor;
	}
}
