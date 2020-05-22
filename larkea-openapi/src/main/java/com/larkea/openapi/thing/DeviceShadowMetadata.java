package com.larkea.openapi.thing;

import java.util.Map;

import com.google.common.collect.Maps;
import lombok.Data;

@Data
public class DeviceShadowMetadata {

    private Map<String, DeviceShadowMetadataObject> reported = Maps.newConcurrentMap();

    private Map<String, DeviceShadowMetadataObject> desired = Maps.newConcurrentMap();

}
