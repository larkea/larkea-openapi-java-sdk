package com.larkea.openapi;

import java.util.List;

import com.huitongio.pete.core.data.Page;

import com.larkea.openapi.device.Device;
import com.larkea.openapi.thing.DeviceProperty;
import com.larkea.openapi.thing.OperationInfo;
import com.larkea.openapi.thing.ThingModel;
import com.larkea.openapi.ts.TsPropertyData;
import com.larkea.openapi.ts.TsPropertyPageQueryParam;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

public interface LarkeaClient {

	@RequestLine("GET /devices")
	Page<Device> listDevices();

	@RequestLine("GET /devices/{deviceId}")
	Device getDeviceById(@Param("deviceId") Long deviceId);

	@RequestLine("GET /devices/{deviceId}/status")
	Device getDeviceStatusById(@Param("deviceId") Long deviceId);

	@RequestLine("GET /things/model?productKey={pk}")
	ThingModel getThingModelByProductKey(@Param("pk") String pk);

	@RequestLine("GET /devices/properties/{propertyId}/data")
	Page<TsPropertyData> listTsPropertyData(@Param("propertyId") Long propertyId,
			@QueryMap TsPropertyPageQueryParam param);

	@RequestLine("GET /devices/properties?productKey={pk}&deviceKey={dk}")
	DeviceProperty getDevicePropertyValue(@Param("pk") String pk, @Param("dk") String dk);

	@RequestLine("GET /products/{productId}/operations")
	List<OperationInfo> listProductOperations(@Param("productId") Long productId);

}
