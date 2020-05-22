package com.larkea.openapi.thing;

import java.util.Map;

import com.larkea.boot.core.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 数据规范
 * </p>
 *
 * @author wangle
 * @since 2020-01-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "DataSpecInfo", description = "数据规范")
public class DataSpecInfo extends BaseModel<DataSpec> {

    @ApiModelProperty(value = "数据规范主键")
    private Long id;

    @ApiModelProperty(value = "功能类型")
    private Long operationId;

    @ApiModelProperty(value = "父数据规范主键")
    private Long parentId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "标识符")
    private String identifier;

    @ApiModelProperty(value = "数据类型")
    private DataType dataType;

    @ApiModelProperty(value = "入参出参")
    private ParamDirection paramDirection;

    @ApiModelProperty(value = "数据规范")
    private Map<String, Object> spec;

}
