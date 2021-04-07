package com.larkea.openapi.exception;

import java.util.Map;

import com.google.common.collect.Maps;
import com.larkea.boot.core.result.ResultCode;
import com.larkea.boot.core.result.SystemResultCode;
import com.larkea.iot.exception.LarkeaIotResultCode;
import com.larkea.usercenter.exception.UsercenterResultCode;

public class ResultCodeUtil {
	public static final Map<Integer, ResultCode> RESULT_CODE_MAP = Maps.newHashMap();

	static {
		for (SystemResultCode resultCode : SystemResultCode.values()) {
			RESULT_CODE_MAP.put(resultCode.getCode(), resultCode);
		}

		for (LarkeaIotResultCode resultCode : LarkeaIotResultCode.values()) {
			RESULT_CODE_MAP.put(resultCode.getCode(), resultCode);
		}

		for (UsercenterResultCode resultCode : UsercenterResultCode.values()) {
			RESULT_CODE_MAP.put(resultCode.getCode(), resultCode);
		}
	}

	private ResultCodeUtil() {
	}

	public static ResultCode getResultCode(int code) {
		return RESULT_CODE_MAP.getOrDefault(code, SystemResultCode.FAILED);
	}
}
