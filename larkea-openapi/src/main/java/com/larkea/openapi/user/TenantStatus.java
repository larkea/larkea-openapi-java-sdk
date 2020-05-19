package com.larkea.openapi.user;

import com.huitongio.pete.core.data.EnumData;

import lombok.Getter;

@Getter
public enum TenantStatus implements EnumData {
	ENABLED(1, "正常"),
	DISABLED(2, "停用");

	Integer value;

	String description;

	TenantStatus(Integer value, String description) {
		this.value = value;
		this.description = description;
	}

}
