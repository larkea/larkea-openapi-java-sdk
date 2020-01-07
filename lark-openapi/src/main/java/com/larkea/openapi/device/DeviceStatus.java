package com.larkea.openapi.device;

import lombok.Getter;

@Getter
public enum DeviceStatus {
  INACTIVE(1, "未激活"),
  ONLINE(2, "在线"),
  OFFLINE(3, "离线"),
  DISABLED(4, "停用"),
  ;

  Integer value;
  String description;

  DeviceStatus(int value, String description) {
    this.value = value;
    this.description = description;
  }

}
