package com.larkea.openapi.product;

import com.larkea.boot.core.data.EnumData;
import lombok.Getter;

/**
 * 产品节点类型
 */
@Getter
public enum NodeType implements EnumData {
    DIRECT(1, "直连设备"),
    NOT_DIRECT(2, "网关子设备"),
    GATEWAY(3, "网关设备"),
    ;

    Integer value;

    String description;

    NodeType(int value, String description) {
        this.value = value;
        this.description = description;
    }
}
