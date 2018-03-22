package com.jinse.blog.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class MD5Util {
	private static final Logger LOGGER = LoggerFactory.getLogger(MD5Util.class);

	private MD5Util() {
	}
	public static String MD5(String text) {
		try {
			final int number = 256;
			final int textLength = 16;
			StringBuffer buf = new StringBuffer();
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(text.getBytes());
			byte[] b = md.digest();
			int i;
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += number;
				if (i < textLength)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("noSuchAlgorithmException");
		} catch (NullPointerException e) {
			LOGGER.error("nullPointerException");
			return null;
		}
		return null;
	}
}
