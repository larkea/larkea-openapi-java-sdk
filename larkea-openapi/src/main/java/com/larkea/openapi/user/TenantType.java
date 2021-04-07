package com.larkea.openapi.user;

import com.larkea.boot.core.data.EnumData;
import lombok.Getter;

@Getter
public enum TenantType implements EnumData {
	PERSONAL(1, "个人"),
	COMPANY(2, "企业");

	Integer value;

	String description;

	TenantType(Integer value, String description) {
		this.value = value;
		this.description = description;
	}

}
