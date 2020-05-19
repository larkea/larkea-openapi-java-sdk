package com.larkea.openapi.product;

import com.huitongio.pete.core.data.BaseData;

import com.larkea.openapi.thing.PubsubFlag;
import com.larkea.openapi.thing.TopicType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
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
@Accessors(chain = true)
@ApiModel(value = "ProductTopic", description = "产品主题")
public class ProductTopic implements BaseData {

	@ApiModelProperty(value = "产品主题主键")
	private Long id;

	@ApiModelProperty(value = "租户主键")
	private Long tenantId;

	@ApiModelProperty(value = "产品主键")
	private Long productId;

	@ApiModelProperty(value = "主题")
	private String topicName;

	@ApiModelProperty(value = "主题类型")
	private TopicType topicType;

	@ApiModelProperty(value = "订阅发布标志")
	private PubsubFlag pubsubFlag;

	@ApiModelProperty(value = "描述")
	private String description;

}
