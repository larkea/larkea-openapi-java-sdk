package com.larkea.openapi.device;

import com.larkea.boot.core.data.EnumData;
import lombok.Getter;

@Getter
public enum DeviceStatus implements EnumData {
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
