package com.sen.client.util;

public class Inspector {
	public static boolean isWhiteSpace(String id) {
		if (id.contains(" ")) {
			return true;
		}
		return false;
	}
	//todo
	public static boolean isCharSize(String idpw) {
		if (idpw.length()>3&&idpw.length()<20) {
			return false;
		}
		return true;
	}
}
