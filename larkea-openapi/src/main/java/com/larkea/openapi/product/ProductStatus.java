package com.larkea.openapi.product;

import com.huitongio.pete.core.data.EnumData;
import com.huitongio.pete.core.data.EnumValue;

import lombok.Getter;

@Getter
public enum ProductStatus implements EnumData {
	DEVELOPMENT(1, "开发中"),
	PUBLISHED(2, "已发布");

	@EnumValue
	Integer value;

	String description;

	ProductStatus(int value, String description) {
		this.value = value;
		this.description = description;
	}
}
