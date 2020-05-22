package com.larkea.openapi.thing;

import java.util.Map;

import com.google.common.collect.Maps;

public final class ThingMqttTopics {

    public static final Map<String, ThingMqttTopic> THING_MQTT_TOPIC_MAP = Maps.newHashMap();

    public static final String BASE_SYSTEM_TOPIC = "/sys";

    public static final String THING_MODEL_GET_TOPIC = BASE_SYSTEM_TOPIC + "/{productKey}/{deviceKey}/thing/model/get";

    public static final String THING_MODEL_GET_ACK_TOPIC = BASE_SYSTEM_TOPIC + "/{productKey}/{deviceKey}/thing/model/getAck";

    public static final String THING_PROPERTY_POST_TOPIC = BASE_SYSTEM_TOPIC + "/{productKey}/{deviceKey}/thing/property/post";

    public static final String THING_PROPERTY_POST_ACK_TOPIC = BASE_SYSTEM_TOPIC + "/{productKey}/{deviceKey}/thing/property/postAck";

    public static final String THING_PROPERTY_SET_TOPIC = BASE_SYSTEM_TOPIC + "/{productKey}/{deviceKey}/thing/property/set";

    public static final String THING_PROPERTY_SET_ACK_TOPIC = BASE_SYSTEM_TOPIC + "/{productKey}/{deviceKey}/thing/property/setAck";

    public static final String THING_PROPERTY_RESET_TOPIC = BASE_SYSTEM_TOPIC + "/{productKey}/{deviceKey}/thing/property/reset";

    public static final String THING_PROPERTY_RESET_ACK_TOPIC = BASE_SYSTEM_TOPIC + "/{productKey}/{deviceKey}/thing/property/resetAck";

    public static final String THING_PROPERTY_DESIRED_GET_TOPIC = BASE_SYSTEM_TOPIC + "/{productKey}/{deviceKey}/thing/property/desired/get";

    public static final String THING_PROPERTY_DESIRED_GET_ACK_TOPIC = BASE_SYSTEM_TOPIC + "/{productKey}/{deviceKey}/thing/property/desired/getAck";

    public static final String THING_PROPERTY_DESIRED_DELETE_TOPIC = BASE_SYSTEM_TOPIC + "/{productKey}/{deviceKey}/thing/property/desired/delete";

    public static final String THING_PROPERTY_DESIRED_DELETE_ACK_TOPIC = BASE_SYSTEM_TOPIC + "/{productKey}/{deviceKey}/thing/property/desired/deleteAck";

    public static final String THING_EVENT_POST_TOPIC = BASE_SYSTEM_TOPIC + "/{productKey}/{deviceKey}/thing/event/post";

    public static final String THING_EVENT_POST_ACK_TOPIC = BASE_SYSTEM_TOPIC + "/{productKey}/{deviceKey}/thing/event/postAck";

    public static final String THING_COMMAND_RUN_TOPIC = BASE_SYSTEM_TOPIC + "/{productKey}/{deviceKey}/thing/command/run";

    public static final String THING_COMMAND_RUN_ACK_TOPIC = BASE_SYSTEM_TOPIC + "/{productKey}/{deviceKey}/thing/command/runAck";

    public static final String THING_REGISTER_ACK = BASE_SYSTEM_TOPIC + "{productKey}/{deviceKey}/thing/registerAck";

    private static final String[][] THING_MQTT_TOPIC_CONFIG = new String[][]{
            {THING_MODEL_GET_TOPIC, "PUB", "请求获取物模型定义 JSON 描述"},
            {THING_MODEL_GET_ACK_TOPIC, "SUB", "返回物模型定义 JSON 描述"},
            {THING_PROPERTY_POST_TOPIC, "PUB", "上报属性"},
            {THING_PROPERTY_POST_ACK_TOPIC, "SUB", "云平台对设备属性的响应"},
            {THING_PROPERTY_SET_TOPIC, "SUB", "云平台设置属性"},
            {THING_PROPERTY_SET_ACK_TOPIC, "PUB", "设备端对设置属性的响应"},
            {THING_PROPERTY_RESET_TOPIC, "PUB", "请求重置属性"},
            {THING_PROPERTY_RESET_ACK_TOPIC, "SUB", "云平台返回需要重置的属性值"},
            {THING_PROPERTY_DESIRED_GET_TOPIC, "PUB", "获取期望属性"},
            {THING_PROPERTY_DESIRED_GET_ACK_TOPIC, "SUB", "云平台返回期望属性"},
            {THING_PROPERTY_DESIRED_DELETE_TOPIC, "PUB", "删除期望属性"},
            {THING_PROPERTY_DESIRED_DELETE_ACK_TOPIC, "SUB", "云平台返回删除结果"},
            {THING_EVENT_POST_TOPIC, "PUB", "上报事件"},
            {THING_EVENT_POST_ACK_TOPIC, "SUB", "云平台对上报事件的响应"},
            {THING_COMMAND_RUN_TOPIC, "SUB", "云平台下发命令"},
            {THING_COMMAND_RUN_ACK_TOPIC, "PUB", "设备端对云平台下发命令的响应"},
            {THING_REGISTER_ACK, "SUB", "云平台对设备下发登录密钥"},
    };

    static {
        for (String[] topicConfig : THING_MQTT_TOPIC_CONFIG) {
            THING_MQTT_TOPIC_MAP.put(topicConfig[0], new ThingMqttTopic(topicConfig[0], PubsubFlag.namesOf(topicConfig[1]), topicConfig[2]));
        }
    }

    private ThingMqttTopics() {
    }
}
