package com.larkea.openapi.product;

import com.huitongio.pete.core.data.EnumData;

import lombok.Getter;

@Getter
public enum ScriptType implements EnumData {
	ECMAScript5(1, "JavaScript(ECMAScript 5)"),
	PYTHON2d7(2, "Python 2.7"),
	;

	Integer value;

	String description;

	ScriptType(Integer value, String description) {
		this.value = value;
		this.description = description;
	}
}
