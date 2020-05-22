package com.larkea.openapi.ts;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@ApiModel(value = "TsPropertyKvEntry", description = "属性时序数据")
public class TsPropertyKvEntry implements TsKvEntry {

    @ApiModelProperty(value = "时序属性值主键")
    private Long id;

    @ApiModelProperty(value = "属性所属产品 ID")
    private Long productId;

    @ApiModelProperty(value = "属性所属设备 ID")
    private Long deviceId;

    @ApiModelProperty(value = "属性的主键")
    private Long propertyId;

    @ApiModelProperty(value = "属性标识符")
    private String key;

    @ApiModelProperty(value = "值")
    private Object value;

    @ApiModelProperty(value = "数据时间戳")
    private Long ts;

    public static TsPropertyKvEntry craft(TsPropertyData tsPropertyData) {
        TsPropertyKvEntry kvEntry = new TsPropertyKvEntry()
                .setValue(tsPropertyData.getValue())
                .setId(tsPropertyData.getId())
                .setProductId(tsPropertyData.getProductId())
                .setDeviceId(tsPropertyData.getDeviceId())
                .setPropertyId(tsPropertyData.getOperationId())
                .setKey(tsPropertyData.getIdentifier())
                .setTs(tsPropertyData.getTs());

        return kvEntry;
    }

    @Override
    @JsonIgnore
    public String getValueAsString() {
        return String.valueOf(this.value);
    }

}
