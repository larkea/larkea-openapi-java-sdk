package com.larkea.openapi.product;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "产品信息", description = "产品信息")
public class ProductCountInfo {

	@ApiModelProperty("设备数")
	private Integer deviceCount = 0;

	@JsonUnwrapped
	private ProductInfo productInfo;

}
