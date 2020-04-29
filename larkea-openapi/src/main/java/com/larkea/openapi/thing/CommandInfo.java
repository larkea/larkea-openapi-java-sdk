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

	@NotNull
	@ApiModelProperty(value = "产品标识", required = true)
	private String productKey;

	@NotNull
	@ApiModelProperty(value = "命令名称", required = true)
	@Length(min = 1, max = 30)
	private String name;

	@NotNull
	@ApiModelProperty(value = "命令标识", required = true)
	@Length(min = 1, max = 50)
	private String identifier;

	@NotNull
	@ApiModelProperty(value = "命令调用方式", required = true)
	private CommandCallType callType;

	@ApiModelProperty(value = "描述")
	private String description;

	@ApiModelProperty(value = "输入参数")
	private List<DataSpecInfo> inputParam;

	@ApiModelProperty(value = "输出参数")
	private List<DataSpecInfo> outputParam;

}
