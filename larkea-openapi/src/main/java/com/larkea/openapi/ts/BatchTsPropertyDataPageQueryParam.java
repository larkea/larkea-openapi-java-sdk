package com.larkea.openapi.ts;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BatchTsPropertyDataPageQueryParam extends TsPropertyDataPageQueryParam {

    private String deviceIdList;

    private String propertyIdList;

}
