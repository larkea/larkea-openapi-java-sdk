package com.larkea.openapi;

import feign.Logger.Level;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "larkea")
@Data
public class LarkeaClientProperties {

	private String url;

	private String accessKey;

	private String accessSecret;

	private Level level;

}
