package com.larkea.openapi.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "产品信息", description = "产品信息")
public class ProductInfo extends Product {

	@ApiModelProperty("产品密钥")
	private String productSecret;

	@ApiModelProperty("设备数")
	private Integer deviceCount = 0;

}
