package com.larkea.openapi.thing;

import java.util.Map;

import com.google.common.collect.Maps;
import lombok.Data;

@Data
public class DeviceShadowState {

    private Map<String, Object> reported = Maps.newConcurrentMap();

    private Map<String, Object> desired = Maps.newConcurrentMap();

}
