package com.larkea.openapi.thing;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

@Data
@Accessors(chain = true)
public class EventParam {

	@NotNull
	@ApiModelProperty(value = "产品标识", required = true)
	private String productKey;

	@NotNull
	@Length(min = 1, max = 30)
	@ApiModelProperty(value = "事件名称", required = true)
	private String name;

	@NotNull
	@Length(min = 1, max = 50)
	@ApiModelProperty(value = "事件标识", required = true)
	private String identifier;

	@NotNull
	@ApiModelProperty(value = "事件类型", required = true)
	private EventType eventType;

	@ApiModelProperty(value = "描述")
	private String description;

	@ApiModelProperty(value = "输出参数")
	private String outputParam;

}
