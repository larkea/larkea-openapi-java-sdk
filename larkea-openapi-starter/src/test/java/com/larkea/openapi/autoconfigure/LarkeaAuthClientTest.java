package com.larkea.openapi.autoconfigure;

import com.larkea.openapi.LarkeaAuthClient;
import com.larkea.openapi.LarkeaClientProperties;
import com.larkea.openapi.token.OAuthToken;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LarkeaAuthClientTest extends BaseOpenApiTest {

	@Autowired
	private LarkeaAuthClient larkeaAuthClient;

	@Autowired
	private LarkeaClientProperties properties;

	@Test
	public void getOAuthToken() {
		OAuthToken oAuthToken = larkeaAuthClient.getOAuthToken(properties.getAccessKey(),
				properties.getAccessSecret());
		assertNotNull(oAuthToken);
	}
}