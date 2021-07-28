package com.vodafone.vftest.contract;

import com.vodafone.vftest.entity.DeviceCardEntity;
import com.vodafone.vftest.entity.DeviceCardEntityPK;

import java.util.List;

/**
 * 7/25/2021
 * CREATED BY @Ayman Alsapagh
 * this ia the contract interface that have abstract methods to be implemented in the business layer
 **/
public interface DeviceCardServiceContarct {

    List<DeviceCardEntity> getAllWFADevices();

    DeviceCardEntity getDeviceByPK(Integer sim, Integer operatorId);

    DeviceCardEntity updateDeviceConfig(DeviceCardEntity deviceCardEntity);

    void deleteDeviceConfig(DeviceCardEntity deviceCardEntity);

    List<DeviceCardEntity>  getAllAvialbleForSaleDevices();
}
