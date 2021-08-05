package com.sen.server.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PropsUtil {
	public static void propsRead()  {
		try {
			SysInfo.dbprops.load(new FileInputStream(""));
		} catch (FileNotFoundException e) {} 
		 catch (IOException e) {} 
	}
}
