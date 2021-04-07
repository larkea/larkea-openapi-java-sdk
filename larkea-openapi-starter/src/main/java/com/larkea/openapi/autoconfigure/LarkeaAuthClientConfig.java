package com.larkea.openapi.autoconfigure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.larkea.boot.core.util.JsonUtil;
import com.larkea.openapi.JacksonDecoder;
import com.larkea.openapi.LarkeaAuthClient;
import com.larkea.openapi.LarkeaClientProperties;
import com.larkea.openapi.LarkeaErrorDecoder;
import com.larkea.openapi.Slf4jLogger;
import feign.Feign;
import feign.Logger.Level;
import feign.codec.ErrorDecoder;
import feign.jackson.JacksonEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class LarkeaAuthClientConfig {

	@Bean
	@ConfigurationProperties(prefix = "larkea")
	LarkeaClientProperties larkeaClientProperties() {
		return new LarkeaClientProperties();
	}

	@Bean
	@ConditionalOnMissingBean(ObjectMapper.class)
	ObjectMapper objectMapper() {
		return JsonUtil.copy();
	}

	@Bean
	LarkeaAuthClient larkAuthClient(LarkeaClientProperties larkeaClientProperties, ObjectMapper mapper) {
		ErrorDecoder errorDecoder = new LarkeaErrorDecoder(mapper);
		return Feign.builder().logger(new Slf4jLogger())
				.logLevel(
						larkeaClientProperties.getHttpLogLevel() == null ? Level.NONE : larkeaClientProperties.getHttpLogLevel())
				.encoder(new JacksonEncoder(mapper))
				.decoder(new JacksonDecoder(mapper))
				.errorDecoder(errorDecoder)
				.target(LarkeaAuthClient.class, larkeaClientProperties.getUrl());
	}
}
