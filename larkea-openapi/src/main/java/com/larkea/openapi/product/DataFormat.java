package com.larkea.openapi.product;

import com.huitongio.pete.core.data.EnumData;

import lombok.Getter;

@Getter
public enum DataFormat implements EnumData {
	HUI_LINK_JSON(1, "慧通标准数据格式"),
	USER(2, "自定义/透传");

	Integer value;

	String description;

	DataFormat(int value, String description) {
		this.value = value;
		this.description = description;
	}
}
