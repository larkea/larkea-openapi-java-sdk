package com.larkea.openapi;

import java.io.IOException;
import java.lang.reflect.Type;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.larkea.boot.core.result.Result;
import com.larkea.boot.core.result.SystemResultCode;
import com.larkea.openapi.exception.LarkeaException;
import com.larkea.openapi.exception.ResultCodeUtil;
import feign.Response;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JacksonDecoder extends feign.jackson.JacksonDecoder {

	@Getter
	private final ObjectMapper mapper;

	private TokenInterceptor tokenInterceptor;

	public JacksonDecoder(ObjectMapper mapper, TokenInterceptor tokenInterceptor) {
		super(mapper);
		this.mapper = mapper;
		this.tokenInterceptor = tokenInterceptor;
	}

	public JacksonDecoder(ObjectMapper mapper) {
		super(mapper);
		this.mapper = mapper;
	}

	@Override
	public Object decode(Response response, Type type) throws IOException {
		JavaType typeWrapped = mapper.getTypeFactory().constructParametricType(
				Result.class, mapper.constructType(type));
		Result<?> result = (Result<?>) super.decode(response, typeWrapped);
		LOGGER.debug("Call larkea api finished:{}", result);
		if (result == null) {
			LOGGER.error("Larkea server returns null");
			throw new LarkeaException(SystemResultCode.FAILED);
		}

		if (result.isSuccess()) {
			return result.getData();
		}

		if (result.getCode() == SystemResultCode.ACCESS_TOKEN_EXPIRED.getCode() && tokenInterceptor != null) {
			tokenInterceptor.renewToken();
		}

		LOGGER.error("Call larkea api failed: {}:{}", result.getCode(),
				result.getMessage());
		throw new LarkeaException(ResultCodeUtil.getResultCode(result.getCode()));

	}
}
