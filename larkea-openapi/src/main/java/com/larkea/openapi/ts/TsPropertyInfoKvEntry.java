package com.larkea.openapi.ts;

import com.larkea.openapi.thing.PropertyInfo;
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
@ApiModel(value = "TsPropertyInfoKvEntry", description = "属性时序数据")
public class TsPropertyInfoKvEntry implements TsKvEntry {

	@ApiModelProperty(value = "时序属性值主键")
	private Long id;

	@ApiModelProperty(value = "属性标识符")
	private String key;

	@ApiModelProperty(value = "值")
	private Object value;

	@ApiModelProperty(value = "数据时间戳")
	private Long ts;

	@ApiModelProperty(value = "属性的定义")
	private PropertyInfo propertyInfo;

	public static TsPropertyInfoKvEntry craft(PropertyInfo propertyInfo, TsPropertyData tsPropertyData) {
		TsPropertyInfoKvEntry kvEntry = new TsPropertyInfoKvEntry()
				.setValue(tsPropertyData.getValue())
				.setId(tsPropertyData.getId())
				.setPropertyInfo(propertyInfo)
				.setKey(propertyInfo.getIdentifier())
				.setTs(tsPropertyData.getTs());

		return kvEntry;
	}

	@Override
	public String getValueAsString() {
		return String.valueOf(this.value);
	}

}
