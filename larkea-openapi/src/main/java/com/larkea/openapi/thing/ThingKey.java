package com.larkea.openapi.thing;

import java.util.Objects;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ThingKey {

    private String productKey;

    private String deviceKey;

    public ThingKey() {
    }

    public ThingKey(String productKey, String deviceKey) {
        this.productKey = productKey;
        this.deviceKey = deviceKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThingKey thingKey = (ThingKey) o;
        return Objects.equals(productKey, thingKey.productKey) &&
                Objects.equals(deviceKey, thingKey.deviceKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productKey, deviceKey);
    }
}
