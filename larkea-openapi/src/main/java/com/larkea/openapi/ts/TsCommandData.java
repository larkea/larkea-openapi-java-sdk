package com.larkea.openapi.ts;

import com.larkea.boot.core.data.BaseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 命令时序数据
 * </p>
 *
 * @author wangle
 * @since 2020-01-12
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "TsCommandData", description = "命令时序数据")
public class TsCommandData implements BaseData {

    @ApiModelProperty(value = "时序属性值主键")
    private Long id;

    @ApiModelProperty(value = "租户主键")
    private Long tenantId;

    @ApiModelProperty(value = "产品主键")
    private Long productId;

    @ApiModelProperty(value = "设备主键")
    private Long deviceId;

    @ApiModelProperty(value = "产品功能主键")
    private Long operationId;

    @ApiModelProperty(value = "命令发送时间戳")
    private Long tsSent;

    @ApiModelProperty(value = "命令完成时间戳")
    private Long tsReceived;

    @ApiModelProperty(value = "输入参数")
    private String inputV;

    @ApiModelProperty(value = "输出参数")
    private String outputV;

}
