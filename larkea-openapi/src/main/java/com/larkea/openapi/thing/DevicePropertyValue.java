package com.larkea.openapi.thing;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DevicePropertyValue {

	private Object value;

	private Long ts;

}
