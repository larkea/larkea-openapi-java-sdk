package com.larkea.openapi.ts;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TsDevicesPageQueryParam extends TsPropertyPageQueryParam {

	@ApiModelProperty("设备 ID 列表")
	String deviceIdList;

}
