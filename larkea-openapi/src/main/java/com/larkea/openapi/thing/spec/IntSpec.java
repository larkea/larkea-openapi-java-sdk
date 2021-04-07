package com.larkea.openapi.thing.spec;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ApiModel(value = "整型数据规范定义")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IntSpec extends NumberSpec {

	@ApiModelProperty(value = "步长", required = true)
	private Long step;

	@ApiModelProperty(value = "最小值", required = true)
	private Long min;

	@ApiModelProperty(value = "最大值", required = true)
	private Long max;

}
