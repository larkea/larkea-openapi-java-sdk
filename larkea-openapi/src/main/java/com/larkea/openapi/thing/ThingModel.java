package com.larkea.openapi.thing;

import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class ThingModel {

	private ThingProfile profile;

	private List<PropertyInfo> properties;

	private List<CommandInfo> commands;

	private List<EventInfo> events;

}
