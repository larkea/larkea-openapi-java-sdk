package com.larkea.openapi;

import com.huitongio.pete.core.util.JsonUtil;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.larkea.openapi.token.OAuthToken;
import feign.Feign;
import feign.Logger.Level;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.jackson.JacksonEncoder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LarkeaClientTest {

	private static LarkeaAuthClient larkeaAuthClient;
	private static LarkeaClient larkeaClient;

	private static final String url = "http://lark.test.pivaiot.com/api";
	private static final String accessKey = "111111111111111111111";
	private static final String accessSecret = "p4X9okJWWX6XiIF99DAgyx4lvyK6GOlU";
	private static final Level httpLogLevel = Level.BASIC;
	private static final ObjectMapper mapper = JsonUtil.copy();

	@BeforeAll
	static void init() {
		initAuthClient();
		initClient();
	}

	static void initAuthClient() {
		larkeaAuthClient = Feign.builder().logger(new Slf4jLogger())
				.logLevel(Level.FULL)
				.encoder(new JacksonEncoder(mapper))
				.decoder(new JacksonDecoder(mapper))
				.target(LarkeaAuthClient.class, url);
	}

	static void initClient() {
		OAuthToken oAuthToken = larkeaAuthClient.getOAuthToken(accessKey, accessSecret);
		assertNotNull(oAuthToken);
		larkeaClient = Feign.builder().logger(new Slf4jLogger())
				.logLevel(httpLogLevel)
				.requestInterceptor(new TokenInterceptor(oAuthToken.getAccessToken()))
				.encoder(new JacksonEncoder(mapper))
				.decoder(new JacksonDecoder(mapper))
				.target(LarkeaClient.class, url);
	}

	@Test
	void listDevices() {
		assertTrue(larkeaClient.listDevices().getTotal() > 0);
	}

	// 所有的接口都添加 token Header
	private static class TokenInterceptor implements RequestInterceptor {

		private transient String token;

		public TokenInterceptor(String token) {
			this.token = token;
		}

		@Override
		public void apply(RequestTemplate template) {
			template.header("Authorization", String.format("Bearer %s", this.token));
		}
	}
}