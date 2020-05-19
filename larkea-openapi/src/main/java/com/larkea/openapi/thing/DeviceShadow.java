package com.larkea.openapi.thing;

import lombok.Data;

@Data
public class DeviceShadow {

	private DeviceShadowState state = new DeviceShadowState();

	private DeviceShadowMetadata metadata = new DeviceShadowMetadata();

	private Long ts;

	private Long version;

}
