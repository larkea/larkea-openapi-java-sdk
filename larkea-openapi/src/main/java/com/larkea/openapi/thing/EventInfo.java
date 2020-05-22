package com.larkea.openapi.thing;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EventInfo {

    @ApiModelProperty(value = "事件主键")
    private Long id;

    @ApiModelProperty(value = "产品主键")
    private Long productId;

    @ApiModelProperty(value = "产品标识", required = true)
    private String productKey;

    @ApiModelProperty(value = "事件名称", required = true)
    private String name;

    @ApiModelProperty(value = "事件标识", required = true)
    private String identifier;

    @ApiModelProperty(value = "事件类型", required = true)
    private EventType eventType;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "输出参数")
    private List<DataSpecInfo> outputParam;

}
