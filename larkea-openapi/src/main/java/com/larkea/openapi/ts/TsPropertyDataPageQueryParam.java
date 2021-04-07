package com.larkea.openapi.ts;

import com.larkea.boot.core.data.PageQueryParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TsPropertyDataPageQueryParam extends PageQueryParam {

	@ApiModelProperty("开始时间戳，毫秒")
	Long tsBegin;

	@ApiModelProperty("结束时间戳，毫秒")
	Long tsEnd;

}
