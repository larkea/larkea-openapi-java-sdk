package com.larkea.openapi.thing.spec;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.larkea.openapi.thing.Spec;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "字符串型数据规范定义")
@Data
public class StringSpec implements Spec {

    @ApiModelProperty(value = "最大长度", required = true)
    @NotNull
    @Min(1)
    @Max(100)
    private Integer length;

}
