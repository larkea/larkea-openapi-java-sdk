package com.larkea.openapi.thing.spec;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.google.common.collect.Maps;
import com.larkea.openapi.thing.Spec;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "布尔型数据规范定义")
@Data
public class BoolSpec implements Spec {

    @ApiModelProperty(value = "布尔项", required = true)
    private Map<String, String> properties = Maps.newHashMap();

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

    @JsonAnySetter
    public void put(String key, String value) {
        properties.put(key, value);
    }

}
