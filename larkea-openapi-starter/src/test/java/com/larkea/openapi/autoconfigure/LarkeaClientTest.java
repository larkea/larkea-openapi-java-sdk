package com.larkea.openapi.autoconfigure;

import java.util.List;

import com.larkea.boot.core.data.Page;
import com.larkea.boot.core.util.StringPool;
import com.larkea.boot.core.util.StringUtil;
import com.larkea.openapi.LarkeaClient;
import com.larkea.openapi.device.DevicePageQueryParam;
import com.larkea.openapi.thing.OperationInfo;
import com.larkea.openapi.thing.ThingModel;
import com.larkea.openapi.ts.BatchTsPropertyDataPageQueryParam;
import com.larkea.openapi.ts.DeviceTsPropertyDataPageQueryParam;
import com.larkea.openapi.ts.TsData;
import com.larkea.openapi.ts.TsPropertyDataPageQueryParam;
import com.larkea.openapi.ts.TsPropertyKvEntry;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class LarkeaClientTest extends BaseOpenApiTest {

	@Autowired
	private LarkeaClient larkeaClient;

	@Test
	public void listDevicesTest() {
		DevicePageQueryParam devicePageQueryParam = new DevicePageQueryParam();
		devicePageQueryParam.setLimit(1000);
		assertTrue(larkeaClient.listDevices(devicePageQueryParam).getTotal() > 0);
	}

	@Test
	public void getThingModelByProductKeyTest() {
		String pk = "5c9LfKakvjB5IWqB9S1oCZ";
		ThingModel model = larkeaClient.getThingModelByProductKey(pk);
		assertNotNull(model);
	}

	@Test
	public void listTsPropertyDataTest() {
		Long propertyId = 50L;
		Long deviceId = 204L;
		TsPropertyDataPageQueryParam param = new TsPropertyDataPageQueryParam();
		Page<TsPropertyKvEntry> dataPage = larkeaClient.listTsPropertyData(deviceId, propertyId, param);
		assertFalse(dataPage.getRows().isEmpty());
	}

	@Test
	public void listTsPropertiesDataTest() {
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
	public void getDevicePropertyValueTest() {
		String pk = "2fAhyOX3BxtHMY7lFF1SHS";
		String dk = "7PyUnXXL199w1EQL78K1pB";
		List<TsData> tsDataList = larkeaClient.getDevicePropertyValues(pk, dk);
	}

	@Test
	public void listProductOperationsTest() {
		Long productId = 23L;
		List<OperationInfo> operationInfoList = larkeaClient.listProductOperations(productId);
		System.out.println(operationInfoList);
	}

	@Test
	public void publishMessageTest() {
		String topicName = "/sys/2fAhyOX3BxtHMY7lFF1SHS/7PyUnXXL199w1EQL78K1pB/thing/property/set";
		String payload = "{\"properties\":{\"component_no\":2,\"action_no\":3,\"cmd_type\":1}}";
		Integer qos = 0;

		larkeaClient.publishMessage(topicName, payload, qos);
	}
}