package com.larkea.openapi.message;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LarkeaMessageMetadata {

	private Long tsMessageReceived;

	private Long tsMessageSent;

	private Integer messageSizeInBytes;

}
