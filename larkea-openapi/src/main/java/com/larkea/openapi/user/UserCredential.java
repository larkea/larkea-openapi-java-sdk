package com.larkea.openapi.user;

import com.huitongio.pete.core.data.BaseData;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户密钥
 * </p>
 *
 * @author wangle
 * @since 2019-12-25
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserCredential", description = "用户密钥")
public class UserCredential implements BaseData {

	@ApiModelProperty(value = "用户密码主键")
	private Long id;

	@ApiModelProperty(value = "用户主键")
	private Long userId;

	@ApiModelProperty(value = "密码")
	private String password;

	@ApiModelProperty(value = "密码盐")
	private String salt;

}
