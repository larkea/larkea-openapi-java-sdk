package com.larkea.openapi.thing.spec;

import com.larkea.openapi.thing.Spec;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public abstract class NumberSpec implements Spec {

    @ApiModelProperty(value = "单位")
    private String unit;

}
