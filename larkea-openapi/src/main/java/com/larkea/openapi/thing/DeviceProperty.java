package com.larkea.openapi.thing;

import java.util.Map;

import com.google.common.collect.Maps;
import com.larkea.openapi.ts.TsData;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DeviceProperty {

    private Long tsLatestUpdated;

    private Map<String, TsData> properties = Maps.newConcurrentMap();

    public DeviceProperty put(String identifier, Object value, Long ts) {
        properties.computeIfAbsent(identifier, key -> new TsData().setKey(key))
                .setValue(value)
                .setTs(ts);
        tsLatestUpdated = System.currentTimeMillis();
        return this;
    }

}
