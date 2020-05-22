package com.larkea.openapi;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Slf4jLogger extends feign.Logger {

    @Override
    protected void log(String configKey, String format, Object... args) {
        LOGGER.debug(String.format(methodTag(configKey) + format, args));
    }
}
