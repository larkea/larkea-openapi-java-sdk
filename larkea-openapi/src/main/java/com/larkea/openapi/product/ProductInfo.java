package com.larkea.openapi.product;

import java.time.LocalDateTime;

import com.huitongio.pete.core.model.BaseModel;

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
@ApiModel(value = "产品", description = "产品")
public class ProductInfo extends BaseModel<Product> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("产品主键")
	private Long id;

	@ApiModelProperty(value = "租户主键")
	private Long tenantId;

	@ApiModelProperty("产品标识")
	private String productKey;

	@ApiModelProperty("产品密钥")
	private String productSecret;

	@ApiModelProperty("产品名称")
	private String name;

	@ApiModelProperty("产品描述")
	private String description;

	@ApiModelProperty("产品状态")
	private ProductStatus status;

	@ApiModelProperty("是否通过设备密钥动态注册")
	private Boolean dynamicRegister;

	@ApiModelProperty("节点类型")
	private NodeType nodeType;

	@ApiModelProperty("认证类型")
	private AuthType authType;

	@ApiModelProperty("连网方式")
	private NetType netType;

	@ApiModelProperty("连接网关方式")
	private GwNetType gwNetType;

	@ApiModelProperty("数据格式")
	private DataFormat dataFormat;

	@ApiModelProperty("创建时间")
	private LocalDateTime gmtCreated;

}
