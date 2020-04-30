package com.larkea.openapi.thing.spec;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.google.common.collect.Maps;
import com.larkea.openapi.thing.Spec;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "枚举类型的数据规范定义")
public class EnumSpec implements Spec {

	@ApiModelProperty(value = "枚举项", required = true)
	private Map<String, String> properties = Maps.newHashMap();

	@JsonAnyGetter
	public Map<String, String> getProperties() {
		return properties;
	}

	@JsonAnySetter
	public void put(String key, String value) {
		properties.put(key, value);
	}

	public boolean containsKey(String key) {
		return properties.containsKey(key);
	}

}
