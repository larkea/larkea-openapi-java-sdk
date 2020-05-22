package com.larkea.openapi.message;

import com.larkea.openapi.thing.ThingKey;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LarkeaMessage<T> {

    private LarkeaMessageType type;

    private ThingKey thingKey;

    private String topicName;

    private Integer qos;

    private LarkeaMessageMetadata metadata;

    private T payload;

}
