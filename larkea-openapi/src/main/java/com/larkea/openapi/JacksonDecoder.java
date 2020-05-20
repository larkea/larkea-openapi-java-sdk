package com.larkea.openapi;

import java.io.IOException;
import java.lang.reflect.Type;

import com.larkea.boot.core.result.Result;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JacksonDecoder extends feign.jackson.JacksonDecoder {

	@Getter
	private final ObjectMapper mapper;

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
		return result.getData();
	}
}
