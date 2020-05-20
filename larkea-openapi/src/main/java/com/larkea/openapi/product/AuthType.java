package com.larkea.openapi.product;

import com.larkea.boot.core.data.EnumData;

import lombok.Getter;

@Getter
public enum AuthType implements EnumData {
	DEVICE_KEY(1, "设备密钥"),
	;

	Integer value;

	String description;

	AuthType(int value, String description) {
		this.value = value;
		this.description = description;
	}
}
