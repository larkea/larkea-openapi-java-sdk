package com.larkea.openapi.message;

import com.huitongio.pete.core.data.EnumData;

import lombok.Getter;

@Getter
public enum LarkeaMessageType implements EnumData {

	DEVICE_UPLINK_MSG(1, "设备上报消息"),
	DEVICE_DOWNLINK_MSG(2, "下发设备消息");

	Integer value;

	String description;

	LarkeaMessageType(Integer value, String description) {
		this.value = value;
		this.description = description;
	}

}
