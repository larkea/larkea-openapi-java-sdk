package com.larkea.openapi.thing;

import java.util.Map;

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
}
