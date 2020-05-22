package com.larkea.openapi.device;

import com.larkea.boot.core.data.BaseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 设备活动日志
 * </p>
 *
 * @author wangle
 * @since 2020-01-12
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "DeviceActivityLog", description = "设备活动日志")
public class DeviceActivity implements BaseData {

    @ApiModelProperty(value = "消息日志主键")
    private Long id;

    @ApiModelProperty(value = "租户主键")
    private Long tenantId;

    @ApiModelProperty(value = "产品主键")
    private Long productId;

    @ApiModelProperty(value = "设备主键")
    private Long deviceId;

    @ApiModelProperty(value = "日志时间戳")
    private Long ts;

    @ApiModelProperty(value = "设备状态")
    private Integer status;

}
