package com.larkea.openapi.thing;

import java.util.Map;

import com.google.common.collect.Maps;
import com.larkea.boot.core.data.EnumData;
import lombok.Getter;

@Getter
public enum PubsubFlag implements EnumData {
    PUB(1, "发布"),
    SUB(2, "订阅"),
    PUB_SUB(2, "发布和订阅"),
    ;

    private static final Map<String, PubsubFlag> MAPPING = Maps.newHashMap();

    static {
        for (PubsubFlag pubsubFlag : values()) {
            MAPPING.put(pubsubFlag.name(), pubsubFlag);
        }
    }

    Integer value;

    String description;

    PubsubFlag(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static PubsubFlag namesOf(String name) {
        return MAPPING.get(name);
    }
}
