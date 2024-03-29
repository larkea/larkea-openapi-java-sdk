package com.larkea.openapi;

import java.util.List;

import com.larkea.boot.core.data.Page;
import com.larkea.openapi.device.DeviceInfo;
import com.larkea.openapi.device.DevicePageQueryParam;
import com.larkea.openapi.device.DeviceStatusInfo;
import com.larkea.openapi.product.ProductInfo;
import com.larkea.openapi.product.ProductPageQueryParam;
import com.larkea.openapi.thing.CommandInfo;
import com.larkea.openapi.thing.EventInfo;
import com.larkea.openapi.thing.OperationInfo;
import com.larkea.openapi.thing.PropertyInfo;
import com.larkea.openapi.thing.ThingModel;
import com.larkea.openapi.token.OAuthToken;
import com.larkea.openapi.ts.BatchTsPropertyDataPageQueryParam;
import com.larkea.openapi.ts.DeviceTsPropertyDataPageQueryParam;
import com.larkea.openapi.ts.TsData;
import com.larkea.openapi.ts.TsPropertyDataPageQueryParam;
import com.larkea.openapi.ts.TsPropertyKvEntry;
import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

public interface LarkeaClient {

	@RequestLine("POST /oauth2/token?grantType=CLIENT_CREDENTIALS&accessKey={accessKey}&accessSecret={accessSecret}")
	OAuthToken getOAuthToken(@Param("accessKey") String accessKey,
			@Param("accessSecret") String accessSecret);

	@RequestLine("GET /products")
	Page<ProductInfo> listProducts(@QueryMap ProductPageQueryParam productPageQueryParam);

	@RequestLine("GET /devices")
	Page<DeviceInfo> listDevices(@QueryMap DevicePageQueryParam devicePageQueryParam);

	@RequestLine("GET /devices/{deviceId}")
	DeviceInfo getDeviceById(@Param("deviceId") Long deviceId);

	@RequestLine("GET /devices/device_info?productKey={productKey}&deviceKey={deviceKey}")
	DeviceInfo getDeviceByPkAndDk(@Param("productKey") String productKey, @Param("deviceKey") String deviceKey);

	@RequestLine("GET /devices/{deviceId}/status")
	DeviceStatusInfo getDeviceStatusById(@Param("deviceId") Long deviceId);

	@RequestLine("GET /things/model?productKey={pk}")
	ThingModel getThingModelByProductKey(@Param("pk") String pk);

	@RequestLine("GET /things/properties/{propertyId}")
	PropertyInfo getProperty(@Param("propertyId") Long propertyId);

	@RequestLine("GET /things/commands/{commandId}")
	CommandInfo getCommand(@Param("commandId") Long commandId);

	@RequestLine("GET /things/events/{eventId}")
	EventInfo getEvent(@Param("eventId") Long eventId);

	@RequestLine("GET /timeseries/properties/{propertyId}?deviceId={deviceId}")
	Page<TsPropertyKvEntry> listTsPropertyData(
			@Param("deviceId") Long deviceId,
			@Param("propertyId") Long propertyId,
			@QueryMap TsPropertyDataPageQueryParam param);

	@RequestLine("GET /timeseries/properties")
	Page<TsPropertyKvEntry> listTsPropertyData(@QueryMap BatchTsPropertyDataPageQueryParam param);

	@RequestLine("GET /timeseries/devices/{deviceId}/keys")
	Page<TsPropertyKvEntry> listDeviceTsPropertyData(
			@Param("deviceId") Long deviceId,
			@QueryMap DeviceTsPropertyDataPageQueryParam param);

	@RequestLine("GET /things/properties/values?productKey={pk}&deviceKey={dk}")
	List<TsData> getDevicePropertyValues(@Param("pk") String pk, @Param("dk") String dk);

	@RequestLine("GET /things/properties/values/batch?deviceIdList={deviceIdList}")
	List<TsPropertyKvEntry> listDevicePropertyValues(@Param("deviceIdList") String deviceIdList);

	@RequestLine("GET /products/{productId}/operations")
	List<OperationInfo> listProductOperations(@Param("productId") Long productId);

	@RequestLine("POST /messages/publish")
	@Headers("Content-Type: application/x-www-form-urlencoded")
	Boolean publishMessage(
			@Param("topicName") String topicName,
			@Param("messagePayload") String messagePayload,
			@Param("qos") Integer qos);

	@RequestLine("GET /timeseries/properties/{propertyId}/all?deviceId={deviceId}&tsBegin={tsBegin}&tsEnd={tsEnd}")
	List<TsPropertyKvEntry> listAllTsPropertyData(@Param("propertyId") Long propertyId,
			@Param("deviceId") Long deviceId,
			@Param("tsBegin") Long tsBegin,
			@Param("tsEnd") Long tsEnd);

}
