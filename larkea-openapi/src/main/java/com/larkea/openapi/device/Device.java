package com.larkea.openapi.device;

import java.time.LocalDateTime;

import com.huitongio.pete.core.data.BaseData;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 设备
 * </p>
 *
 * @author wangle
 * @since 2019-12-25
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "Device", description = "设备")
public class Device implements BaseData {

	@ApiModelProperty(value = "设备主键")
	private Long id;

	@ApiModelProperty(value = "租户主键")
	private Long tenantId;

	@ApiModelProperty(value = "产品主键")
	private Long productId;

	@ApiModelProperty(value = "产品标识")
	private String productKey;

	@ApiModelProperty(value = "设备标识")
	private String deviceKey;

	@ApiModelProperty(value = "注册方式")
	private RegisterType registerType;

	@ApiModelProperty(value = "设备名称")
	private String name;

	@ApiModelProperty(value = "设备IP地址")
	private String ipAddr;

	@ApiModelProperty(value = "设备固件版本")
	private String firmwareVersion;

	@ApiModelProperty(value = "激活时间")
	private LocalDateTime gmtActive;

	@ApiModelProperty(value = "最后上线时间")
	private LocalDateTime gmtOnline;

	@ApiModelProperty(value = "状态")
	private DeviceStatus status;

}
