package com.qf.util;

import java.util.UUID;

public class UUIDUtils {
	public static String getUUID() {
		String uuid=UUID.randomUUID().toString().replaceAll("-","");
		return uuid;
	}
}
