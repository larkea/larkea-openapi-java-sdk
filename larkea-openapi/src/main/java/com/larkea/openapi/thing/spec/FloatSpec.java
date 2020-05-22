package com.larkea.openapi.thing.spec;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel(value = "浮点型数据规范定义")
@Data
@EqualsAndHashCode(callSuper = true)
public class FloatSpec extends NumberSpec {

    @ApiModelProperty(value = "步长", required = true)
    private Double step;

    @ApiModelProperty(value = "最小值", required = true)
    private Double min;

    @ApiModelProperty(value = "最大值", required = true)
    private Double max;

}
