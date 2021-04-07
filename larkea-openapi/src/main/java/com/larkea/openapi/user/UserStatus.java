package com.larkea.openapi.user;

import com.larkea.boot.core.data.EnumData;
import lombok.Getter;

@Getter
public enum UserStatus implements EnumData {
	ENABLED(1, "正常"),
	DISABLED(2, "停用");

	Integer value;

	String description;

	UserStatus(Integer value, String description) {
		this.value = value;
		this.description = description;
	}

}
