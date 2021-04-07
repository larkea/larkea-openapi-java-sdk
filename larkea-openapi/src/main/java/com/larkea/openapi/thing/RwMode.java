package com.larkea.openapi.thing;

import com.larkea.boot.core.data.EnumData;
import lombok.Getter;

/**
 * 数据的读写类型
 */
@Getter
public enum RwMode implements EnumData {
	R(1, "只读"),
	RW(2, "读写"),
	;

	Integer value;

	String description;

	RwMode(int value, String description) {
		this.value = value;
		this.description = description;
	}
}
