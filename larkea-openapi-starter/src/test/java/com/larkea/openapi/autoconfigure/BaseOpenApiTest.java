package com.larkea.openapi.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { LarkeaAuthClientConfig.class, LarkeaClientConfig.class },
		initializers = ConfigFileApplicationContextInitializer.class)
@EnableConfigurationProperties
public class BaseOpenApiTest {

	@Before
	public void init() {
		LOGGER.info("---------------开始测试-----------------");
	}

	@After
	public void after() {
		LOGGER.info("---------------测试结束-----------------");
	}

}