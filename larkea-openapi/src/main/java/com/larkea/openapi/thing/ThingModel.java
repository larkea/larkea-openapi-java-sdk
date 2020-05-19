package com.larkea.openapi.thing;

import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ThingModel {

	private String productKey;

	private List<PropertyInfo> properties;

	private List<CommandInfo> commands;

	private List<EventInfo> events;

}
