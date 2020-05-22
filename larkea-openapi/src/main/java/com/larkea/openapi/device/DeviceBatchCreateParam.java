package com.larkea.openapi.device;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.larkea.boot.core.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "创建设备参数", description = "设备")
public class DeviceBatchCreateParam extends BaseModel<Device> {

    @ApiModelProperty(value = "产品主键", required = true)
    @NotNull
    private String productKey;

    @ApiModelProperty(value = "设备数量", required = true)
    @Max(2000)
    @Min(1)
    @NotNull
    private Integer deviceCount;

}
