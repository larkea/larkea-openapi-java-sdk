package com.larkea.openapi.thing;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

@Data
@Accessors(chain = true)
public class CommandInfo {

	@ApiModelProperty(value = "命令主键")
	private Long id;

    @ApiModelProperty(value = "产品主键")
    private Long productId;

	@ApiModelProperty(value = "产品标识", required = true)
	private String productKey;

	@ApiModelProperty(value = "命令名称", required = true)
	private String name;

	@ApiModelProperty(value = "命令标识", required = true)
	private String identifier;

	@ApiModelProperty(value = "命令调用方式", required = true)
	private CommandCallType callType;

	@ApiModelProperty(value = "描述")
	private String description;

	@ApiModelProperty(value = "输入参数")
	private List<DataSpecInfo> inputParam;

	@ApiModelProperty(value = "输出参数")
	private List<DataSpecInfo> outputParam;

}
