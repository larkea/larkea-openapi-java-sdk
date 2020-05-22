package com.larkea.openapi.thing.spec;

import com.larkea.openapi.thing.Spec;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "时间型数据规范定义")
@Data
public class DateSpec implements Spec {

    @ApiModelProperty(value = "时间格式", required = true)
    private String pattern;

}
