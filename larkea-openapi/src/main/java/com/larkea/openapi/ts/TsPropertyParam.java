package com.larkea.openapi.ts;

import com.huitongio.pete.core.model.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 属性时序数据
 * </p>
 *
 * @author wangle
 * @since 2020-01-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "TsProperty参数", description = "属性时序数据")
public class TsPropertyParam extends BaseModel<TsProperty> {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "租户主键")
	private Long tenantId;

	@ApiModelProperty(value = "产品主键")
	private Long productId;

	@ApiModelProperty(value = "设备主键")
	private Long deviceId;

	@ApiModelProperty(value = "产品功能主键")
	private Long operationId;

	@ApiModelProperty(value = "数据时间戳")
	private Long ts;

	@ApiModelProperty(value = "int32/int64/bool/enum/date值")
	private Long intV;

	@ApiModelProperty(value = "float32/float64值")
	private Double floatV;

	@ApiModelProperty(value = "字符串值")
	private String strV;

}
