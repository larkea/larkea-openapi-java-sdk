package com.larkea.openapi.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ClientIdUtil {

	public static String getClientId(String productKey, String deviceKey) {
		return String.format("%s.%s", productKey, deviceKey);
	}

	public static Object getClientIdLock(String clientId) {
		return clientId.intern();
	}

}
