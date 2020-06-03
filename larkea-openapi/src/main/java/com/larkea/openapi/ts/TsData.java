package com.larkea.openapi.ts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TsData implements TsKvEntry {

    @ApiModelProperty(value = "属性标识符")
    private String key;

    @ApiModelProperty(value = "值")
    private Object value;

    @ApiModelProperty(value = "数据时间戳")
    private Long ts;

    @Override
	@JsonIgnore
    public String getValueAsString() {
        return String.valueOf(value);
    }
}
