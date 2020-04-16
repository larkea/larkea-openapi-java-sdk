package com.larkea.openapi;

import com.larkea.openapi.token.OAuthToken;
import feign.Param;
import feign.RequestLine;

public interface LarkeaAuthClient {

  @RequestLine("POST /oauth2/token?grantType=CLIENT_CREDENTIALS&accessKey={accessKey}&accessSecret={accessSecret}")
  OAuthToken getOAuthToken(@Param("accessKey") String accessKey,
      @Param("accessSecret") String accessSecret);

}
