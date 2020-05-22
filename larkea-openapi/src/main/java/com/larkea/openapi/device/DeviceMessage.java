package com.larkea.openapi.device;

import com.larkea.boot.core.data.BaseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 设备消息
 * </p>
 *
 * @author wangle
 * @since 2020-01-12
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "DeviceMessage", description = "设备消息")
public class DeviceMessage implements BaseData {

    @ApiModelProperty(value = "消息主键")
    private Long id;

    @ApiModelProperty(value = "租户主键")
    private Long tenantId;

    @ApiModelProperty(value = "产品主键")
    private Long productId;

    @ApiModelProperty(value = "设备主键")
    private Long deviceId;

    @ApiModelProperty(value = "消息上下行")
    private Integer direction;

    @ApiModelProperty(value = "时间戳")
    private Long ts;

    @ApiModelProperty(value = "类型")
    private Integer msgType;

    @ApiModelProperty(value = "消息状态")
    private Integer status;

    @ApiModelProperty(value = "内容")
    private String content;

}
