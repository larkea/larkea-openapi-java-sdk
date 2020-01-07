package com.larkea.openapi.autoconfigure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.larkea.openapi.JacksonDecoder;
import com.larkea.openapi.LarkAuthClient;
import com.larkea.openapi.LarkClient;
import com.larkea.openapi.LarkClientProperties;
import com.larkea.openapi.Slf4jLogger;
import com.larkea.openapi.token.OAuthToken;
import feign.Feign;
import feign.Logger.Level;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.jackson.JacksonEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class LarkClientConfig {

  @Bean
  LarkClient larkClient(LarkAuthClient larkAuthClient, LarkClientProperties larkClientProperties,
      ObjectMapper mapper) {
    OAuthToken oAuthToken = larkAuthClient
        .getOAuthToken(larkClientProperties.getAccessKey(), larkClientProperties.getAccessSecret());

    return Feign.builder().logger(new Slf4jLogger())
        .logLevel(
            larkClientProperties.getLevel() == null ? Level.NONE : larkClientProperties.getLevel())
        .requestInterceptor(new TokenInterceptor(oAuthToken.getAccessToken()))
        .encoder(new JacksonEncoder(mapper))
        .decoder(new JacksonDecoder(mapper))
        .target(LarkClient.class, larkClientProperties.getUrl());
  }

  // 所有的接口都添加 token Header
  private static class TokenInterceptor implements RequestInterceptor {

    private String token;

    public TokenInterceptor(String token) {
      this.token = token;
    }

    @Override
    public void apply(RequestTemplate template) {
      template.header("Authorization", String.format("Bearer %s", this.token));
    }
  }
}
