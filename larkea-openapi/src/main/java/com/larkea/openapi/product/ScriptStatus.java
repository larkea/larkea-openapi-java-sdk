package com.larkea.openapi.product;

import com.larkea.boot.core.data.EnumData;
import lombok.Getter;

@Getter
public enum ScriptStatus implements EnumData {
    DRAFT(1, "草稿"),
    PUBLISHED(2, "已发布"),
    ;

    Integer value;

    String description;

    ScriptStatus(Integer value, String description) {
        this.value = value;
        this.description = description;
    }
}
