package com.larkea.openapi.product;

import com.huitongio.pete.core.data.EnumData;

import lombok.Getter;

@Getter
public enum PubsubFlag implements EnumData {
	SYSTEM(1, "系统主题"),
	CUSTOM(2, "自定义主题"),
	;

	Integer value;

	String description;

	PubsubFlag(int value, String description) {
		this.value = value;
		this.description = description;
	}
}
