package com.larkea.openapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.larkea.boot.core.result.Result;
import com.larkea.boot.core.result.SystemResultCode;
import com.larkea.openapi.exception.LarkeaException;
import com.larkea.openapi.exception.ResultCodeUtil;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LarkeaErrorDecoder implements ErrorDecoder {

	private ObjectMapper objectMapper;

	public LarkeaErrorDecoder(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public Exception decode(String methodKey, Response response) {
		String responseJson = response.body().toString();
		Result<?> result = fromJson(responseJson, Result.class);
		if (result == null) {
			return new LarkeaException(SystemResultCode.FAILED);
		}

		return new LarkeaException(ResultCodeUtil.getResultCode(result.getCode()));
	}

	/**
	 * Convert json to a Class<T> object.
	 */
	private  <T> T fromJson(String json, Class<T> clazz) {
		try {
			return objectMapper.readValue(json, clazz);
		} catch (Exception e) {
			LOGGER.warn("Convert response json to class failed: {}", json);
			throw new LarkeaException(SystemResultCode.FAILED);
		}
	}
}
