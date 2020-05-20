package com.larkea.openapi.product;

import com.larkea.boot.core.data.EnumData;

import lombok.Getter;

/**
 * 连接网关的协议
 */
@Getter
public enum GwNetType implements EnumData {
	MODBUS(1, "Modbus 协议"),
	OPC_UA(2, "OPC UA 协议"),
	BLE(3, "蓝牙低功耗协议"),
	ZIGBEE(4, "ZigBee协议"),
	OTHER(99, "其它");

	Integer value;

	String description;

	GwNetType(int value, String description) {
		this.value = value;
		this.description = description;
	}
}
