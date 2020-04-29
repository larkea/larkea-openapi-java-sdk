package com.larkea.openapi.thing;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OperationInfo {

	private OperationType operationType;

	@JsonUnwrapped
	private PropertyInfo propertyInfo;

	@JsonUnwrapped
	private EventInfo eventInfo;

	@JsonUnwrapped
	private CommandInfo commandInfo;

}
