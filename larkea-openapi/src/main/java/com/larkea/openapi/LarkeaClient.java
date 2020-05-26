package com.larkea.openapi;

import java.util.List;

import com.larkea.boot.core.data.Page;
import com.larkea.boot.core.data.PageQueryParam;
import com.larkea.openapi.device.DeviceInfo;
import com.larkea.openapi.device.DevicePageQueryParam;
import com.larkea.openapi.device.DeviceStatusInfo;
import com.larkea.openapi.thing.CommandInfo;
import com.larkea.openapi.thing.EventInfo;
import com.larkea.openapi.thing.OperationInfo;
import com.larkea.openapi.thing.PropertyInfo;
import com.larkea.openapi.thing.ThingModel;
import com.larkea.openapi.ts.BatchTsPropertyDataPageQueryParam;
import com.larkea.openapi.ts.DeviceTsPropertyDataPageQueryParam;
import com.larkea.openapi.ts.TsData;
import com.larkea.openapi.ts.TsPropertyDataPageQueryParam;
import com.larkea.openapi.ts.TsPropertyKvEntry;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

public interface LarkeaClient {

    @RequestLine("GET /devices")
    Page<DeviceInfo> listDevices(@QueryMap DevicePageQueryParam devicePageQueryParam);

    @RequestLine("GET /devices/{deviceId}")
    DeviceInfo getDeviceById(@Param("deviceId") Long deviceId);

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
            @Param("propertyId") Long propertyId,
            @Param("deviceId") Long deviceId,
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

}
