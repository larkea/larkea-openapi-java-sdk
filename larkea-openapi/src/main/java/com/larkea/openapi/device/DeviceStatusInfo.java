package com.larkea.openapi.device;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DeviceStatusInfo {

    private String deviceKey;

    private String name;

    @ApiModelProperty(value = "设备固件版本")
    private String firmwareVersion;

	@ApiModelProperty(value = "激活时间")
	private LocalDateTime gmtActivated;

	@ApiModelProperty(value = "最后上线时间")
    private LocalDateTime gmtOnline;

    @ApiModelProperty(value = "最后下线线时间")
    private LocalDateTime gmtOffline;

    private DeviceStatus status;

}
