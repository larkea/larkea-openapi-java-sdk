package com.larkea.openapi.thing;

import com.larkea.boot.core.data.EnumData;
import lombok.Getter;

@Getter
public enum EventType implements EnumData {
    NOTICE(1, "通知"),
    WARNING(2, "告警"),
    ERROR(3, "故障"),
    ;

    Integer value;

    String description;

    EventType(Integer value, String description) {
        this.value = value;
        this.description = description;
    }
}
