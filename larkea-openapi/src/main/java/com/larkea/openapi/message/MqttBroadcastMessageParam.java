package com.larkea.openapi.message;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MqttBroadcastMessageParam {

	@ApiModelProperty(value = "主题")
	private String topicName;

	@ApiModelProperty(value = "消息体")
	private String messagePayload;

}
