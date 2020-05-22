package com.larkea.openapi.thing;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DevicePropertyUpdateParam {

    @ApiModelProperty(value = "产品标识", required = true)
    @NotNull
    @NotBlank
    private String productKey;

    @ApiModelProperty(value = "设备标识", required = true)
    @NotNull
    @NotBlank
    private String deviceKey;

    @ApiModelProperty(value = "属性列表, 转义后的 JSON 字符串，{\"propertyIdentifier\":propertyValue}", required = true)
    @NotNull
    @NotBlank
    private String properties;

    @ApiModelProperty("设备不在线时是否缓存在云端，默认是 false")
    private Boolean desired = false;

}
