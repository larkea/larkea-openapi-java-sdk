package com.larkea.openapi.thing;

import lombok.Data;

@Data
public class ThingMqttTopic {

	private String topicNamePattern;

	private PubsubFlag pubsubFlag;

	private String description;

	public ThingMqttTopic() {
	}

	public ThingMqttTopic(String topicNamePattern, PubsubFlag pubsubFlag, String description) {
		this.topicNamePattern = topicNamePattern;
		this.pubsubFlag = pubsubFlag;
		this.description = description;
	}
}
