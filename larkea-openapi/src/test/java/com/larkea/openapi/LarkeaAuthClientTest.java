package com.larkea.openapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.larkea.boot.core.util.JsonUtil;
import com.larkea.openapi.token.OAuthToken;
import feign.Feign;
import feign.Logger.Level;
import feign.jackson.JacksonEncoder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class LarkeaAuthClientTest {

	@Test
	void getOAuthToken() {
		String url = "http://lark.test.pivaiot.com/api";
		String accessKey = "SrOQvh5AOR4rZ9Wt";
		String accessSecret = "p4X9okJWWX6XiIF99DAgyx4lvyK6GOlU";

		ObjectMapper mapper = JsonUtil.copy();
		LarkeaAuthClient larkeaAuthClient = Feign.builder().logger(new Slf4jLogger())
				.logLevel(Level.FULL)
				.encoder(new JacksonEncoder(mapper))
				.decoder(new JacksonDecoder(mapper))
				.target(LarkeaAuthClient.class, url);

		OAuthToken oAuthToken = larkeaAuthClient.getOAuthToken(accessKey, accessSecret);
		assertNotNull(oAuthToken);
	}
}