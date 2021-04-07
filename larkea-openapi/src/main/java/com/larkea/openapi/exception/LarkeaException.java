package com.larkea.openapi.exception;

import com.larkea.boot.core.exception.SystemException;
import com.larkea.boot.core.result.Result;
import com.larkea.boot.core.result.ResultCode;

public class LarkeaException extends SystemException {

	public LarkeaException(Result<?> result) {
		super(result);
	}

	public LarkeaException(ResultCode resultCode) {
		super(resultCode);
	}

	public LarkeaException(ResultCode resultCode, String message) {
		super(resultCode, message);
	}

	public LarkeaException(String message) {
		super(message);
	}

	public LarkeaException(Throwable cause) {
		super(cause);
	}

	public LarkeaException(String message, Throwable cause) {
		super(message, cause);
	}
}
