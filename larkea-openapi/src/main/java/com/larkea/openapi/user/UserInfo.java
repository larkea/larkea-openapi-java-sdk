package com.larkea.openapi.user;

import com.larkea.boot.core.model.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author wangle
 * @since 2019-12-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "UserInfo", description = "用户")
public class UserInfo extends BaseModel<User> {

	@ApiModelProperty(value = "用户主键")
	private Long id;

	@ApiModelProperty(value = "账号")
	private String username;

	@ApiModelProperty(value = "邮箱")
	private String email;

	@ApiModelProperty(value = "手机")
	private String mobile;

	@ApiModelProperty(value = "租户主键")
	private Long tenantId;

	@ApiModelProperty(value = "头像")
	private String avatarUrl;

	@ApiModelProperty(value = "状态")
	private UserStatus status;

}
