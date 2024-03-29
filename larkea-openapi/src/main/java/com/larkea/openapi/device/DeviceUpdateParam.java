package com.larkea.openapi.device;

import com.larkea.boot.core.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

/**
 * <p>
 * 设备
 * </p>
 *
 * @author wangle
 * @since 2019-12-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "创建设备参数", description = "设备")
public class DeviceUpdateParam extends BaseModel<Device> {

	@ApiModelProperty(value = "设备名称")
	@Length(min = 0, max = 64)
	private String name;

}
