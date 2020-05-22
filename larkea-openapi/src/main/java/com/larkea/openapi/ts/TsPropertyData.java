package com.larkea.openapi.ts;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.larkea.boot.core.data.BaseData;
import com.larkea.boot.core.util.CastUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 属性时序数据
 * </p>
 *
 * @author wangle
 * @since 2020-01-12
 */
@Slf4j
@Data
@Accessors(chain = true)
@ApiModel(value = "TsPropertyData", description = "属性时序数据")
public class TsPropertyData implements BaseData {

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

    @ApiModelProperty(value = "产品属性标识")
    private String identifier;

    @ApiModelProperty(value = "数据时间戳")
    private Long ts;

    @ApiModelProperty(value = "int32/int64/bool/enum/date值")
    private Long intV;

    @ApiModelProperty(value = "float32/float64值")
    private Double floatV;

    @ApiModelProperty(value = "字符串值")
    private String strV;

    @ApiModelProperty(value = "值")
    public Object getValue() {
        if (intV != null) {
            return intV;
        } else if (floatV != null) {
            return floatV;
        } else {
            return strV;
        }
    }

    public TsPropertyData setValue(Object value) {
        if (value == null) {
            return null;
        }

        // 设置对应的值
        if (value instanceof Byte
                || value instanceof Short
                || value instanceof Integer
                || value instanceof Long
                || value instanceof BigInteger) {
            this.intV = CastUtil.cast(value);
        } else if (value instanceof Float
                || value instanceof Double
                || value instanceof BigDecimal) {
            this.floatV = CastUtil.cast(value);
        } else if (value instanceof Boolean) {
            this.intV = ((Boolean) value) ? 1L : 0L;
        } else if (value instanceof String) {
            this.strV = CastUtil.cast(value);
        } else {
            LOGGER.warn(
                    "Time series property value type is not supported , now is {}",
                    value.getClass().getSimpleName());
            return null;
        }

        return this;
    }
}
