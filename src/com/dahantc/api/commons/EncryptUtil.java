package com.dahantc.api.commons;

import java.security.MessageDigest;

public class EncryptUtil {
	public static String MD5Encode(String sourceString) {
		String resultString = null;
		try {
			resultString = new String(sourceString);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byte2hexString(md.digest(resultString.getBytes()));
		} catch (Exception localException) {
		}
		return resultString;
	}

	private static final String byte2hexString(byte[] bytes) {
		StringBuffer bf = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			if ((bytes[i] & 0xFF) < 16) {
				bf.append("0");
			}
			bf.append(Long.toString(bytes[i] & 0xFF, 16));
		}
		return bf.toString();
	}

}