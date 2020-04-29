package com.larkea.openapi.product;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

/**
 * <p>
 * 产品
 * </p>
 *
 * @author wangle
 * @since 2019-12-25
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "编辑产品", description = "产品")
public class ProductUpdateParam {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "产品名称")
	@NotBlank
	@Length(min = 4, max = 30)
	private String name;

	@ApiModelProperty(value = "产品描述")
	private String description;

}
