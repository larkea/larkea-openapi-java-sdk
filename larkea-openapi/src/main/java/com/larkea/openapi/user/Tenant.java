package com.larkea.openapi.user;

import com.larkea.boot.core.data.BaseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 租户
 * </p>
 *
 * @author wangle
 * @since 2019-12-25
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "Tenant", description = "租户")
public class Tenant implements BaseData {

	@ApiModelProperty(value = "租户主键")
	private Long id;

	@ApiModelProperty(value = "租户标识")
	private String tenantKey;

	@ApiModelProperty(value = "租户名称")
	private String tenantName;

	@ApiModelProperty(value = "租户类型")
	private TenantType tenantType;

	@ApiModelProperty(value = "状态")
	private TenantStatus status;

}
