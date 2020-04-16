package com.larkea.openapi.autoconfigure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.larkea.openapi.JacksonDecoder;
import com.larkea.openapi.LarkeaAuthClient;
import com.larkea.openapi.LarkeaClientProperties;
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
    LarkeaClientProperties.class
})
public class LarkAuthClientConfig {

  @Bean
  LarkeaAuthClient larkAuthClient(LarkeaClientProperties larkeaClientProperties, ObjectMapper mapper) {
    return Feign.builder().logger(new Slf4jLogger())
        .logLevel(
            larkeaClientProperties.getLevel() == null ? Level.NONE : larkeaClientProperties.getLevel())
        .encoder(new JacksonEncoder(mapper))
        .decoder(new JacksonDecoder(mapper))
        .target(LarkeaAuthClient.class, larkeaClientProperties.getUrl());
  }
}
