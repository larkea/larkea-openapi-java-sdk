package com.larkea.openapi.ts;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TsPropertiesPageQueryParam extends TsPropertyPageQueryParam {

	@ApiModelProperty("属性 ID 列表")
	String propertyIdList;

}
