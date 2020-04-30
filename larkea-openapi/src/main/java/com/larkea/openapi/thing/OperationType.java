package com.larkea.openapi.thing;

import com.huitongio.pete.core.data.EnumData;

import lombok.Getter;

@Getter
public enum OperationType implements EnumData {
	PROPERTY(1, "属性"),
	COMMAND(2, "命令"),
	EVENT(3, "事件"),
	;

	Integer value;

	String description;

	OperationType(Integer value, String description) {
		this.value = value;
		this.description = description;
	}
}
