package com.jinse.blog.utils;

import java.util.Date;

import com.jinse.blog.pojo.User;

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
}
