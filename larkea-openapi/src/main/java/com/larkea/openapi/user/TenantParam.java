package com.larkea.openapi.user;

import com.larkea.boot.core.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "Tenant参数", description = "租户")
public class TenantParam extends BaseModel<Tenant> {

    @ApiModelProperty(value = "租户标识")
    private String tenantKey;

    @ApiModelProperty(value = "租户名称")
    private String tenantName;

    @ApiModelProperty(value = "租户类型")
    private Integer tenantType;

    @ApiModelProperty(value = "状态")
    private Integer status;

}
