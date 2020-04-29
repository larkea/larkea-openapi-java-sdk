package com.larkea.openapi.product;

import com.huitongio.pete.core.data.EnumData;

import lombok.Getter;

/**
 * 产品网络类型
 */
@Getter
public enum NetType implements EnumData {
	WIFI(1, "Wi-Fi"),
	CELLULAR(2, "蜂窝网络(2G/3G/4G/5G)"),
	ETHERNET(3, "以太网络"),
	LORAWAN(4, "LoRaWan"),
	OTHER(99, "其它");

	Integer value;

	String description;

	NetType(int value, String description) {
		this.value = value;
		this.description = description;
	}

}
