package org.magnun.mobilecloud.notification;


public class StringUtils {

	public static boolean isEmpty(String s) {
		if (s == null) {
			return true;
		}

		if (s.length() < 1) {
			return true;
		}

		return false;
	}
	
	public static boolean isBlank(String s) {
		if (isEmpty(s)) {
			return true;
		}

		if (isEmpty(s.trim())) {
			return true;
		}

		return false;
	}
}
