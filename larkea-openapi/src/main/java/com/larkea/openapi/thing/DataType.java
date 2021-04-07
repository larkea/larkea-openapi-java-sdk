package com.larkea.openapi.thing;

import java.util.Map;

import com.google.common.collect.Maps;
import com.larkea.boot.core.data.EnumData;
import com.larkea.openapi.thing.spec.BoolSpec;
import com.larkea.openapi.thing.spec.DateSpec;
import com.larkea.openapi.thing.spec.EnumSpec;
import com.larkea.openapi.thing.spec.FloatSpec;
import com.larkea.openapi.thing.spec.IntSpec;
import com.larkea.openapi.thing.spec.StringSpec;
import lombok.Getter;

@Getter
public enum DataType implements EnumData {
	INT32(1, "整型"),
	INT64(2, "长整型"),
	FLOAT32(3, "单精度浮点型"),
	FLOAT64(4, "双精度浮点型"),
	BOOL(5, "布尔型"),
	ENUM(6, "枚举型"),
	STRING(7, "字符串"),
	DATE(8, "时间型"),
	;

	private final static Map<DataType, Class<? extends Spec>> dataTypeClassMap = Maps.newHashMap();

	static {
		dataTypeClassMap.put(INT32, IntSpec.class);
		dataTypeClassMap.put(INT64, IntSpec.class);
		dataTypeClassMap.put(FLOAT32, FloatSpec.class);
		dataTypeClassMap.put(FLOAT64, FloatSpec.class);
		dataTypeClassMap.put(BOOL, BoolSpec.class);
		dataTypeClassMap.put(ENUM, EnumSpec.class);
		dataTypeClassMap.put(STRING, StringSpec.class);
		dataTypeClassMap.put(DATE, DateSpec.class);
	}

	Integer value;

	String description;

	DataType(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public Class<? extends Spec> getSpecClass() {
		return dataTypeClassMap.get(this);
	}
}
