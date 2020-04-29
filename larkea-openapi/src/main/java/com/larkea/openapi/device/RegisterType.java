package com.larkea.openapi.device;

import com.huitongio.pete.core.data.EnumData;

import lombok.Getter;

/**
 * 用于表示设备注册的方式
 */
@Getter
public enum RegisterType implements EnumData {
	SYSTEM(1, "系统注册"),
	DYNAMIC(2, "产品动态注册"),
	;

	Integer value;

	String description;

	RegisterType(Integer value, String description) {
		this.value = value;
		this.description = description;
	}
}
