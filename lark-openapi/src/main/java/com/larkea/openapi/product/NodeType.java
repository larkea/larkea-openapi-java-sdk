package com.larkea.openapi.product;

import lombok.Getter;

/**
 * 产品节点类型
 */
@Getter
public enum NodeType {
  DIRECT(1, "直连设备"),
  SUB_DEVICE(2, "网关子设备"),
  GATEWAY(3, "网关设备"),
  ;

  Integer value;
  String description;

  NodeType(int value, String description) {
    this.value = value;
    this.description = description;
  }
}
