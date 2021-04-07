package com.larkea.openapi.device;

import com.larkea.boot.core.data.PageQueryParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DevicePageQueryParam extends PageQueryParam {

	@ApiModelProperty(value = "产品标识")
	private String productKey;

	private String name;

	private String deviceKey;

}
