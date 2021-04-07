package com.larkea.openapi.attribute;

import com.larkea.boot.core.data.EnumData;
import lombok.Getter;

@Getter
public enum AttributeEntityType implements EnumData {
	PRODUCT(1, "产品"),
	DEVICE(2, "设备"),
	;

	Integer value;

	String description;

	AttributeEntityType(int value, String description) {
		this.value = value;
		this.description = description;
	}

}
