package com.larkea.openapi.ts;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DeviceTsPropertyDataPageQueryParam extends TsPropertyDataPageQueryParam {

	private String keyList;

}
