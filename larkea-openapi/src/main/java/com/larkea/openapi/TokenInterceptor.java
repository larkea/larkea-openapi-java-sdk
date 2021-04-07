package com.larkea.openapi;

import java.time.LocalDateTime;

import com.larkea.openapi.token.OAuthToken;
import feign.RequestInterceptor;
import feign.RequestTemplate;

public class TokenInterceptor implements RequestInterceptor {

	private final LarkeaAuthClient larkeaAuthClient;

	private final LarkeaClientProperties properties;

	private OAuthToken token;

	public TokenInterceptor(LarkeaAuthClient larkeaAuthClient, LarkeaClientProperties properties) {
		this.larkeaAuthClient = larkeaAuthClient;
		this.properties = properties;

		if (this.properties.getLazy() != null && !this.properties.getLazy()) {
			this.token = this.larkeaAuthClient.getOAuthToken(this.properties.getAccessKey(),
					this.properties.getAccessSecret());
		}
	}

	@Override
	public void apply(RequestTemplate template) {
		if (token == null) {
			renewToken();
		}

		if (token.getGmtAccessTokenExpired().isBefore(LocalDateTime.now())) {
			renewToken();
		}

		template.header("Authorization", String.format("Bearer %s", token.getAccessToken()));
	}

	public void renewToken() {
		this.token = larkeaAuthClient.getOAuthToken(properties.getAccessKey(),
				properties.getAccessSecret());
	}

}
