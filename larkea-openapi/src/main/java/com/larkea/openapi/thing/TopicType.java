package com.larkea.openapi.thing;

import com.larkea.boot.core.data.EnumData;
import lombok.Getter;

@Getter
public enum TopicType implements EnumData {
	SYSTEM(1, "系统主题"),
	USER(2, "用户主题"),
	;

	Integer value;

	String description;

	TopicType(int value, String description) {
		this.value = value;
		this.description = description;
	}
}
