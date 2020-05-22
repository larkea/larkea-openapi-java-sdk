package com.larkea.openapi.thing;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

@Data
@Accessors(chain = true)
public class PropertyParam {

    @NotNull
    @ApiModelProperty(value = "产品标识", required = true)
    private String productKey;

    @NotNull
    @Length(min = 1, max = 30)
    @ApiModelProperty(value = "属性名称", required = true)
    private String name;

    @NotNull
    @Length(min = 1, max = 50)
    @ApiModelProperty(value = "属性标识", required = true)
    private String identifier;

    @NotNull
    @ApiModelProperty(value = "读写权限", required = true)
    private RwMode rwMode;

    @NotNull
    @ApiModelProperty(value = "数据类型", required = true)
    private DataType dataType;

    private String description;

    @NotNull
    private String spec;
}
