package com.larkea.openapi.thing;

import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OperationInfo {

    @ApiModelProperty(value = "属性主键")
    private Long id;

    @ApiModelProperty(value = "功能类型")
    private OperationType operationType;

    @ApiModelProperty(value = "产品主键")
    private Long productId;

    @ApiModelProperty(value = "产品标识")
    private String productKey;

    @ApiModelProperty(value = "属性名称")
    private String name;

    @ApiModelProperty(value = "属性标识")
    private String identifier;

    @ApiModelProperty(value = "读写权限")
    private RwMode rwMode;

    @ApiModelProperty(value = "数据类型")
    private DataType dataType;

    @ApiModelProperty(value = "属性说明")
    private String description;

    @ApiModelProperty(value = "属性定义规范")
    private Map<String, Object> spec;

    @ApiModelProperty(value = "事件类型", required = true)
    private EventType eventType;

    @ApiModelProperty(value = "输出参数")
    private List<DataSpecInfo> outputParam;

    @ApiModelProperty(value = "命令调用方式", required = true)
    private CommandCallType callType;

    @ApiModelProperty(value = "输入参数")
    private List<DataSpecInfo> inputParam;
}
