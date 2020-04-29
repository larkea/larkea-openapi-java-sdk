package com.larkea.openapi.thing;

import com.huitongio.pete.core.data.EnumData;

import lombok.Getter;

@Getter
public enum CommandCallType implements EnumData {
	SYNC(1, "同步"),
	ASYNC(2, "异步"),
	;

	Integer value;

	String description;

	CommandCallType(Integer value, String description) {
		this.value = value;
		this.description = description;
	}
}
