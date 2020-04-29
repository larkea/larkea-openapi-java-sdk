package com.larkea.openapi.thing;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

@Data
@Accessors(chain = true)
public class PropertyInfo {

	@ApiModelProperty(value = "属性主键")
	private Long id;

	@NotNull
	@ApiModelProperty(value = "产品标识")
	private String productKey;

	@NotNull
	@Length(min = 1, max = 30)
	@ApiModelProperty(value = "产品名称")
	private String name;

	@NotNull
	@Length(min = 1, max = 50)
	@ApiModelProperty(value = "产品标识")
	private String identifier;

	@NotNull
	@ApiModelProperty(value = "读写权限")
	private RwMode rwMode;

	@NotNull
	@ApiModelProperty(value = "数据类型")
	private DataType dataType;

	private String description;

	@NotNull
	private Spec spec;
}
