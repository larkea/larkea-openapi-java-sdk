package com.larkea.openapi;

import java.util.List;

import com.larkea.boot.core.data.Page;
import com.larkea.boot.core.util.JsonUtil;
import com.larkea.boot.core.util.StringPool;
import com.larkea.boot.core.util.StringUtil;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.larkea.openapi.thing.OperationInfo;
import com.larkea.openapi.thing.ThingModel;
import com.larkea.openapi.token.OAuthToken;
import com.larkea.openapi.ts.BatchTsPropertyDataPageQueryParam;
import com.larkea.openapi.ts.DeviceTsPropertyDataPageQueryParam;
import com.larkea.openapi.ts.TsData;
import com.larkea.openapi.ts.TsPropertyDataPageQueryParam;
import com.larkea.openapi.ts.TsPropertyKvEntry;
import feign.Feign;
import feign.Logger.Level;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.jackson.JacksonEncoder;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LarkeaClientTest {

	private static final String url = "http://lark.test.pivaiot.com/api";
	//private static final String url = "http://127.0.0.1:9020";

	private static final String accessKey = "111111111111111111111";

	private static final String accessSecret = "p4X9okJWWX6XiIF99DAgyx4lvyK6GOlU";

	private static final Level HTTP_LOG_LEVEL = Level.BASIC;

	private static final ObjectMapper mapper = JsonUtil.copy();

	private static LarkeaAuthClient larkeaAuthClient;

	private static LarkeaClient larkeaClient;

	@BeforeAll
	static void init() {
		initAuthClient();
		initClient();
	}

	static void initAuthClient() {
		larkeaAuthClient = Feign.builder().logger(new Slf4jLogger())
				.logLevel(Level.FULL)
				.encoder(new JacksonEncoder(mapper))
				.decoder(new JacksonDecoder(mapper))
				.target(LarkeaAuthClient.class, url);
	}

	static void initClient() {
		OAuthToken oAuthToken = larkeaAuthClient.getOAuthToken(accessKey, accessSecret);
		assertNotNull(oAuthToken);
		larkeaClient = Feign.builder().logger(new Slf4jLogger())
				.logLevel(HTTP_LOG_LEVEL)
				.queryMapEncoder(new LarkeaQueryMapEncoder())
				.requestInterceptor(new TokenInterceptor(oAuthToken.getAccessToken()))
				.encoder(new JacksonEncoder(mapper))
				.decoder(new JacksonDecoder(mapper))
				.target(LarkeaClient.class, url);
	}

	@Test
	void listDevicesTest() {
		assertTrue(larkeaClient.listDevices().getTotal() > 0);
	}

	@Test
	void getThingModelByProductKeyTest() {
		String pk = "5c9LfKakvjB5IWqB9S1oCZ";
		ThingModel model = larkeaClient.getThingModelByProductKey(pk);
		assertNotNull(model);
	}

	@Test
	void listTsPropertyDataTest() {
		Long propertyId = 50L;
		Long deviceId = 204L;
		TsPropertyDataPageQueryParam param = new TsPropertyDataPageQueryParam();
		Page<TsPropertyKvEntry> dataPage = larkeaClient.listTsPropertyData(deviceId, propertyId, param);
		assertFalse(dataPage.getRows().isEmpty());
	}

	@Test
	void listTsPropertiesDataTest() {
		BatchTsPropertyDataPageQueryParam param = new BatchTsPropertyDataPageQueryParam();
		param.setPropertyIdList(StringUtil.join(Lists.newArrayList(47L, 50L), StringPool.COMMA));
		param.setDeviceIdList(StringUtil.join(Lists.newArrayList(204L, 204L), StringPool.COMMA));
		Page<TsPropertyKvEntry> dataPage = larkeaClient.listTsPropertyData(param);
		System.out.println(dataPage);
		assertFalse(dataPage.getRows().isEmpty());

		DeviceTsPropertyDataPageQueryParam p = new DeviceTsPropertyDataPageQueryParam();
		Long deviceId = 204L;
		p.setKeyList(StringUtil.join(Lists.newArrayList("action_no"), StringPool.COMMA));
		dataPage = larkeaClient.listDeviceTsPropertyData(deviceId, p);
		System.out.println(dataPage);
		assertFalse(dataPage.getRows().isEmpty());
	}

	@Test
	void getDevicePropertyValueTest() {
		String pk = "2fAhyOX3BxtHMY7lFF1SHS";
		String dk = "7PyUnXXL199w1EQL78K1pB";
		List<TsData> tsDataList = larkeaClient.getDevicePropertyValues(pk, dk);
	}

	@Test
    void listProductOperationsTest() {
	    Long productId = 23L;
	    List<OperationInfo> operationInfoList = larkeaClient.listProductOperations(productId);
        System.out.println(operationInfoList);
    }

	// 所有的接口都添加 token Header
	private static class TokenInterceptor implements RequestInterceptor {

		private transient String token;

		public TokenInterceptor(String token) {
			this.token = token;
		}

		@Override
		public void apply(RequestTemplate template) {
			template.header("Authorization", String.format("Bearer %s", this.token));
		}
	}
}