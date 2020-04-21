package com.larkea.openapi.device;

import java.time.LocalDateTime;

import com.larkea.openapi.product.Product;
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
@ApiModel(value = "设备", description = "设备")
public class Device {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "设备主键")
	private Long id;

	@ApiModelProperty(value = "租户主键")
	private Long tenantId;

	@ApiModelProperty(value = "产品")
	private Product product;

	@ApiModelProperty(value = "设备标识")
	private String deviceKey;

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
