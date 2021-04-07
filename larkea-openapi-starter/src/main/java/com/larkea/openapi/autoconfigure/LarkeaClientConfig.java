package com.larkea.openapi.autoconfigure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.larkea.openapi.JacksonDecoder;
import com.larkea.openapi.LarkeaAuthClient;
import com.larkea.openapi.LarkeaClient;
import com.larkea.openapi.LarkeaEncoder;
import com.larkea.openapi.LarkeaClientProperties;
import com.larkea.openapi.LarkeaQueryMapEncoder;
import com.larkea.openapi.Slf4jLogger;
import com.larkea.openapi.TokenInterceptor;
import com.larkea.openapi.token.OAuthToken;
import feign.Feign;
import feign.Logger.Level;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.form.FormEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class LarkeaClientConfig {

	@Bean
	LarkeaClient larkClient(LarkeaAuthClient larkeaAuthClient, LarkeaClientProperties larkeaClientProperties,
			ObjectMapper mapper) {
		TokenInterceptor tokenInterceptor = new TokenInterceptor(larkeaAuthClient, larkeaClientProperties);
		return Feign.builder().logger(new Slf4jLogger())
				.queryMapEncoder(new LarkeaQueryMapEncoder())
				.logLevel(
						larkeaClientProperties.getHttpLogLevel() == null ? Level.NONE : larkeaClientProperties.getHttpLogLevel())
				.requestInterceptor(tokenInterceptor)
				.encoder(new LarkeaEncoder(mapper))
				.decoder(new JacksonDecoder(mapper, tokenInterceptor))
				.target(LarkeaClient.class, larkeaClientProperties.getUrl());
	}

}
