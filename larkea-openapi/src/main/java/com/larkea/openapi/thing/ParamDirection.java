package com.larkea.openapi.thing;

import com.larkea.boot.core.data.EnumData;
import lombok.Getter;

@Getter
public enum ParamDirection implements EnumData {
	INPUT(1, "入参"),
	OUTPUT(2, "出参"),
	;

	Integer value;

	String description;

	ParamDirection(Integer value, String description) {
		this.value = value;
		this.description = description;
	}
}
