package com.larkea.openapi;

import feign.Logger.Level;
import lombok.Data;

@Data
public class LarkeaClientProperties {

	private String url;

	private String accessKey;

	private String accessSecret;

	private Level httpLogLevel;

	private Boolean lazy = true;

}
