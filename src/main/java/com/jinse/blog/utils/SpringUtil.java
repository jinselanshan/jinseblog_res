package com.jinse.blog.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.jinse.blog.pojo.User;

public class SpringUtil implements ApplicationContextAware {
	/**
	 * 当前IOC
	 */
	private static ApplicationContext applicationContext;

	/**
	 * 设置当前上下文环境，此方法由spring自动装配
	 */

	public void setApplicationContext(ApplicationContext arg0) {
		applicationContext = arg0;
	}

	/**
	 * 从当前IOC获取bean
	 * 
	 * @param id
	 *            bean的id
	 * @return
	 */
	public static Object getBean(String id) {
		Object object = null;
		object = applicationContext.getBean(id);
		return object;
	}

	public static void setSession(String key, Object obj) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				session.setAttribute(key, obj);
			}
		}
	}

	public static Object getObject(String key) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			if (null != session) {
				return session.getAttribute(key);
			}
		}
		return null;
	}

	public static User getCurrentUser() {
		User currentUser = null;
		if (SpringUtil.getObject(ConstantsUtil.STRING_CURRENT_USER) != null) {
			currentUser = (User) SpringUtil.getObject(ConstantsUtil.STRING_CURRENT_USER);
		}
		return currentUser;
	}

/*	public static Project getCurrentProject() {
		Project currentProject = null;
		if (SpringUtil.getObject(ConstantsUtil.STRING_CURRENT_PROJECT) != null) {
			currentProject = (Project) SpringUtil.getObject(ConstantsUtil.STRING_CURRENT_PROJECT);
		}
		return currentProject;
	}
	
	public static Release getCurrentRelease(){
		Release currentRelease = null;
		if(SpringUtil.getObject(ConstantsUtil.STRING_CURRENT_RELEASE)!=null){
			currentRelease = (Release)SpringUtil.getObject(ConstantsUtil.STRING_CURRENT_RELEASE);
		}
		
		return currentRelease;
	}
*/
}
