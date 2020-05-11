package com.larkea.openapi;

import java.util.List;

import com.huitongio.pete.core.data.Page;

import com.larkea.openapi.device.DeviceInfo;
import com.larkea.openapi.device.DeviceStatusInfo;
import com.larkea.openapi.thing.DeviceProperty;
import com.larkea.openapi.thing.OperationInfo;
import com.larkea.openapi.thing.ThingModel;
import com.larkea.openapi.ts.TsDevicePropertyData;
import com.larkea.openapi.ts.TsPropertiesPageQueryParam;
import com.larkea.openapi.ts.TsPropertyData;
import com.larkea.openapi.ts.TsPropertyPageQueryParam;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

public interface LarkeaClient {

	@RequestLine("GET /devices")
	Page<DeviceInfo> listDevices();

	@RequestLine("GET /devices/{deviceId}")
	DeviceInfo getDeviceById(@Param("deviceId") Long deviceId);

	@RequestLine("GET /devices/{deviceId}/status")
	DeviceStatusInfo getDeviceStatusById(@Param("deviceId") Long deviceId);

	@RequestLine("GET /things/model?productKey={pk}")
	ThingModel getThingModelByProductKey(@Param("pk") String pk);

	@RequestLine("GET /properties/{propertyId}/data")
	Page<TsPropertyData> listTsPropertyData(@Param("propertyId") Long propertyId,
			@QueryMap TsPropertyPageQueryParam param);

	@RequestLine("GET /properties/data")
	Page<TsDevicePropertyData> listTsDevicePropertyData(@QueryMap TsPropertiesPageQueryParam param);

	@RequestLine("GET /properties?productKey={pk}&deviceKey={dk}")
	DeviceProperty getDevicePropertyValue(@Param("pk") String pk, @Param("dk") String dk);

	@RequestLine("GET /products/{productId}/operations")
	List<OperationInfo> listProductOperations(@Param("productId") Long productId);

}
