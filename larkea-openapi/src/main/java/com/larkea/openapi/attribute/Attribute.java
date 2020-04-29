package com.larkea.openapi.attribute;

import com.huitongio.pete.core.data.BaseData;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 特性
 * </p>
 *
 * @author wangle
 * @since 2019-12-25
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "Attribute", description = "特性")
public class Attribute implements BaseData {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "特性主键")
	private Long id;

	@ApiModelProperty(value = "实体主键")
	private Long entityId;

	@ApiModelProperty(value = "实体类型")
	private Integer entityType;

	@ApiModelProperty(value = "特性标识")
	private String attrKey;

	@ApiModelProperty(value = "特性值")
	private String attrValue;

}
