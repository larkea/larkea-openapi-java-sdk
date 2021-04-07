package com.larkea.openapi;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class TokenInterceptor implements RequestInterceptor {

	private final LarkeaAuthClient larkeaAuthClient;

	private final LarkeaClientProperties properties;

	private String token;

	public TokenInterceptor(LarkeaAuthClient larkeaAuthClient, LarkeaClientProperties properties) {
		this.larkeaAuthClient = larkeaAuthClient;
		this.properties = properties;

		if (this.properties.getLazy() != null && !this.properties.getLazy()) {
			this.token = this.larkeaAuthClient.getOAuthToken(this.properties.getAccessKey(),
					this.properties.getAccessSecret()).getAccessToken();
		}
	}

	@Override
	public void apply(RequestTemplate template) {
		if (token == null) {
			renewToken();
		}

		template.header("Authorization", String.format("Bearer %s", token));
	}

	public void renewToken() {
		this.token = larkeaAuthClient.getOAuthToken(properties.getAccessKey(),
				properties.getAccessSecret()).getAccessToken();
	}

}
