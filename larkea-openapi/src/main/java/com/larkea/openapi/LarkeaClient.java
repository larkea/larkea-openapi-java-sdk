package com.larkea.openapi;

import com.huitongio.pete.core.data.Page;

import com.larkea.openapi.device.Device;
import feign.Param;
import feign.RequestLine;

public interface LarkeaClient {

	@RequestLine("GET /devices")
	Page<Device> listDevices();

	@RequestLine("GET /devices/{deviceId}")
	Device getDeviceById(@Param("deviceId") Long deviceId);

	@RequestLine("GET /devices/{deviceId}/status")
	Device getDeviceStatusById(@Param("deviceId") Long deviceId);

}
