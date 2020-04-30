package com.larkea.openapi.ts;

import com.huitongio.pete.core.data.BaseData;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
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
@Accessors(chain = true)
@ApiModel(value = "TsProperty", description = "属性时序数据")
public class TsPropertyData implements BaseData {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "时序属性值主键")
	private Long id;

	@ApiModelProperty(value = "数据时间戳")
	private Long ts;

	@ApiModelProperty(value = "值")
	private Object value;

	public TsPropertyData() {
	}

	public TsPropertyData(TsProperty tsProperty) {
		if (tsProperty.getIntV() != null) {
			this.value = tsProperty.getIntV();
		}
		else if (tsProperty.getFloatV() != null) {
			this.value = tsProperty.getFloatV();
		}
		else {
			this.value = tsProperty.getStrV();
		}

		this.id = tsProperty.getId();
		this.ts = tsProperty.getTs();
	}
}
