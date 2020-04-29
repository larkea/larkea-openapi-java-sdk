package com.larkea.openapi.thing;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ThingIdentity {

	private String productKey;

	private String deviceKey;

}
