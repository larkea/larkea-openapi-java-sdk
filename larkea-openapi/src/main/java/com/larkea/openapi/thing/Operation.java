package com.larkea.openapi.thing;

import com.larkea.boot.core.data.BaseData;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 产品功能
 * </p>
 *
 * @author wangle
 * @since 2020-01-10
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "Operation", description = "产品功能")
public class Operation implements BaseData {

	@ApiModelProperty(value = "主键")
	private Long id;

	@ApiModelProperty(value = "租户主键")
	private Long tenantId;

	@ApiModelProperty(value = "产品主键")
	private Long productId;

	@ApiModelProperty(value = "功能类型")
	private OperationType operationType;

	@ApiModelProperty(value = "功能标识符")
	private String identifier;

	@ApiModelProperty(value = "功能名称")
	private String name;

	@ApiModelProperty(value = "属性读写权限")
	private RwMode rwMode;

	@ApiModelProperty(value = "命令调用方式")
	private CommandCallType callType;

	@ApiModelProperty(value = "事件类型")
	private EventType eventType;

	@ApiModelProperty(value = "描述")
	private String description;

}
