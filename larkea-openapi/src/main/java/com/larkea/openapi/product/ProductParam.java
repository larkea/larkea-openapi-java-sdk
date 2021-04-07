package com.larkea.openapi.product;

import com.larkea.boot.core.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 产品
 * </p>
 *
 * @author wangle
 * @since 2020-01-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "Product参数", description = "产品")
public class ProductParam extends BaseModel<Product> {

	@ApiModelProperty(value = "租户主键")
	private Long tenantId;

	@ApiModelProperty(value = "产品标识")
	private String productKey;

	@ApiModelProperty(value = "产品名称")
	private String name;

	@ApiModelProperty(value = "产品描述")
	private String description;

	@ApiModelProperty(value = "产品状态")
	private Integer status;

	@ApiModelProperty(value = "是否通过设备密钥动态注册")
	private Boolean dynamicRegister;

	@ApiModelProperty(value = "节点类型")
	private Integer nodeType;

	@ApiModelProperty(value = "认证类型")
	private Integer authType;

	@ApiModelProperty(value = "连网方式")
	private Integer netType;

	@ApiModelProperty(value = "连接网关方式")
	private Integer gwNetType;

	@ApiModelProperty(value = "数据格式")
	private Integer dataFormat;

}
