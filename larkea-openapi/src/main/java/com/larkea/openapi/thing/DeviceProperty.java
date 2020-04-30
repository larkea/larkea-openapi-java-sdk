package com.larkea.openapi.thing;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Maps;
import com.larkea.openapi.device.DeviceInfo;
import com.larkea.openapi.device.DeviceStatus;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DeviceProperty {

	@JsonIgnore
	private DeviceInfo deviceInfo;

	private DeviceStatus status;

	private Long tsLatestUpdated;

	private Map<String, DevicePropertyValue> properties = Maps.newConcurrentMap();

	public DeviceProperty addDevicePropertyValue(String identifier, Long ts, Object value) {
		DevicePropertyValue devicePropertyValue = new DevicePropertyValue()
				.setValue(value)
				.setTs(ts);
		tsLatestUpdated = ts;
		properties.put(identifier, devicePropertyValue);
		return this;
	}

}
