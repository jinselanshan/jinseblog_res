package com.jinse.blog.shiro;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jinse.blog.pojo.User;
import com.jinse.blog.service.PermissionsService;
import com.jinse.blog.service.RoleService;
import com.jinse.blog.service.UserService;



public class UserRealm extends AuthorizingRealm {
	private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);

    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;

    /**
     * 为当前登录的Subject授予角色和权限
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		List<String> roles = new ArrayList<String>();
		List<String> permissions = new ArrayList<String>();

		// 为当前用户设置角色和权限
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(roles);
		info.addStringPermissions(permissions);
		return info;

	}
    /**
	 * 验证当前登录的Subject
	 * 
	 * @see经测试:本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()时
	 */

	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		SimpleAuthenticationInfo info = null;
		// 获取基于用户名和密码的令牌
		// 实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		logger.info(token.isRememberMe()+"");
        token.setRememberMe(false);
        logger.info(token.isRememberMe()+"");
		// 从数据库中查询用户用信息
		User user = userService.findUserByUsername(token.getUsername());

		if (user == null) {
			throw new UnknownAccountException("User:" + token.getUsername() + " do not exist!");
		} else if (!user.getPassword().equals(String.valueOf(token.getPassword()))) {
			throw new IncorrectCredentialsException("password not correct！");
		} else {
			info = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
			return info;
		}

	}
}