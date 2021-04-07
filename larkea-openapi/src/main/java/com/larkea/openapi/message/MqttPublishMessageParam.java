package com.larkea.openapi.message;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MqttPublishMessageParam {

	@ApiModelProperty(value = "主题", required = true)
	@NotNull
	@NotBlank
	private String topicName;

	@ApiModelProperty(value = "消息体", required = true)
	@NotNull
	@NotBlank
	private String messagePayload;

	@ApiModelProperty(value = "Qos, 0或者1")
	private Integer qos = 0;

}
