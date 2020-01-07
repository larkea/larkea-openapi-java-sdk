package com.larkea.openapi.token;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * <p>
 * 令牌
 * </p>
 *
 * @author wangle
 * @since 2019-12-25
 */
@Data
public class OAuthToken {

  private TokenType tokenType;

  @ApiModelProperty(value = "访问令牌")
  private String accessToken;

  @ApiModelProperty(value = "刷新令牌")
  private String refreshToken;

  @ApiModelProperty(value = "访问令牌过期时间")
  private LocalDateTime gmtAccessTokenExpired;

  @ApiModelProperty(value = "刷新令牌过期时间")
  private LocalDateTime gmtRefreshTokenExpired;


}
