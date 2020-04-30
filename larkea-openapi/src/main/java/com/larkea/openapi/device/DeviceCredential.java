package com.larkea.openapi.device;

import com.huitongio.pete.core.data.BaseData;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 设备密钥
 * </p>
 *
 * @author wangle
 * @since 2019-12-25
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "DeviceCredential", description = "设备密钥")
public class DeviceCredential implements BaseData {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "设备密钥主键")
	private Long id;

	@ApiModelProperty(value = "设备主键")
	private Long deviceId;

	@ApiModelProperty(value = "设备标识")
	private String deviceKey;

	@ApiModelProperty(value = "设备密钥")
	private String deviceSecret;

}
