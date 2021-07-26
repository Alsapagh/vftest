package com.vodafone.vftest.service;

import com.google.common.math.Stats;
import com.vodafone.vftest.contract.DeviceCardServiceContarct;
import com.vodafone.vftest.entity.DeviceCardEntity;
import com.vodafone.vftest.entity.DeviceCardEntityPK;
import com.vodafone.vftest.enums.Status;
import com.vodafone.vftest.repo.DeviceCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 7/25/2021
 * CREATED BY @Ayman Alsapagh
 **/
@Service
public class DeviceCardService implements DeviceCardServiceContarct {

    @Autowired
    DeviceCardRepo deviceCardRepo;

    @Override
    public List<DeviceCardEntity> getAllWFADevices() {
//        return deviceCardRepo.findAllByStatus(Status.WAITING_FOR_ACTIVATION);
        return deviceCardRepo.findAllByStatus(Status.WAITING_FOR_ACTIVATION);
    }

    @Override
    public DeviceCardEntity getDeviceByPK(Integer sim, Integer OperatorId) {
        DeviceCardEntityPK deviceCardEntityPK = new DeviceCardEntityPK();
        deviceCardEntityPK.setOperatorCode(OperatorId);
        deviceCardEntityPK.setSimId(sim);
        Optional<DeviceCardEntity> res = deviceCardRepo.findById(deviceCardEntityPK);
        return res.orElse(null);
    }

    @Override
    public DeviceCardEntity updateDeviceConfig(DeviceCardEntity deviceCardEntity) {
        return deviceCardRepo.save(deviceCardEntity);
    }

    @Override
    public void deleteDeviceConfig(DeviceCardEntity deviceCardEntity) {
        deviceCardRepo.delete(deviceCardEntity);
    }

    @Override
    public List<DeviceCardEntity> getAllAvialbleForSaleDevices() {
        return deviceCardRepo.findAllByStatus(Status.READY);
    }

}