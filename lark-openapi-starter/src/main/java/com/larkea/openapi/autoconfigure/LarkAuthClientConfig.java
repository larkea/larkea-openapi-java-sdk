package com.larkea.openapi.autoconfigure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.larkea.openapi.JacksonDecoder;
import com.larkea.openapi.LarkAuthClient;
import com.larkea.openapi.LarkClientProperties;
import com.larkea.openapi.Slf4jLogger;
import feign.Feign;
import feign.Logger.Level;
import feign.jackson.JacksonEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableConfigurationProperties({
    LarkClientProperties.class
})
public class LarkAuthClientConfig {

  @Bean
  LarkAuthClient larkAuthClient(LarkClientProperties larkClientProperties, ObjectMapper mapper) {
    return Feign.builder().logger(new Slf4jLogger())
        .logLevel(
            larkClientProperties.getLevel() == null ? Level.NONE : larkClientProperties.getLevel())
        .encoder(new JacksonEncoder(mapper))
        .decoder(new JacksonDecoder(mapper))
        .target(LarkAuthClient.class, larkClientProperties.getUrl());
  }
}
