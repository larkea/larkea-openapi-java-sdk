package com.larkea.openapi.product;

import com.larkea.boot.core.model.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 产品主题
 * </p>
 *
 * @author wangle
 * @since 2019-12-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "ProductTopic参数", description = "产品主题")
public class ProductTopicParam extends BaseModel<ProductTopic> {

	@ApiModelProperty(value = "租户主键")
	private Long tenantId;

	@ApiModelProperty(value = "产品主键")
	private Long productId;

	@ApiModelProperty(value = "主题")
	private String topic;

	@ApiModelProperty(value = "主题类型")
	private Integer topicType;

	@ApiModelProperty(value = "订阅发布标志")
	private Integer pubsubFlag;

	@ApiModelProperty(value = "描述")
	private String description;

}
