package com.sen.server.service;

import com.sen.server.util.SysInfo;



public class Finder {
	public static MultiChatRunnable socket(String to) {
		for(MultiChatRunnable toRunnable : SysInfo.users.keySet()) {
			if(SysInfo.users.get(toRunnable).getCid().equals(to)) {
				return toRunnable;
			}
		}
		return null;
	}
}
