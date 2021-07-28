package com.vodafone.vftest.controller;

import com.vodafone.vftest.contract.DeviceCardServiceContarct;
import com.vodafone.vftest.entity.DeviceCardEntity;
import com.vodafone.vftest.entity.DeviceCardEntityPK;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 7/25/2021
 * CREATED BY @Ayman Alsapagh
 * this class for mapping the APIs Calling
 **/
@RestController
@RequestMapping("/api")
public class DeviceCardController {

    @Autowired
    DeviceCardServiceContarct deviceCardServiceContarct;

    @ApiOperation(value = "Returns all devices in the warehouse that are waiting for activation", response = DeviceCardEntity.class, responseContainer = "List")
    @RequestMapping(method = RequestMethod.GET, value = "/wfa", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DeviceCardEntity>> getAllWFADevices() {
        return new ResponseEntity<>(deviceCardServiceContarct.getAllWFADevices(), HttpStatus.OK);

    }

    @ApiOperation(value = "Returns specific device in the warehouse by PK", response = DeviceCardEntity.class)
    @RequestMapping(method = RequestMethod.GET, value = "/getDevice", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeviceCardEntity> getDeviceByPK(@RequestParam() Integer sim,@RequestParam() Integer operatorId) {
        return new ResponseEntity<>(deviceCardServiceContarct.getDeviceByPK(sim,operatorId), HttpStatus.OK);

    }

    @ApiOperation(value = "Management endpoints that enable the shop manager to update a device configuration status ", response = DeviceCardEntity.class)
    @RequestMapping(method = RequestMethod.POST, value = "/device", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeviceCardEntity> updateDeviceConfig(
            @RequestBody() DeviceCardEntity deviceCardEntity) {
        return new ResponseEntity<>(deviceCardServiceContarct.updateDeviceConfig(deviceCardEntity), HttpStatus.OK);
    }

    @ApiOperation(value = "Management endpoints that enable the shop manager to remove configuration status ", response = String.class)
    @RequestMapping(method = RequestMethod.DELETE, value = "/device", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteDeviceConfig(
            @RequestBody() DeviceCardEntity deviceCardEntity) {
        deviceCardServiceContarct.deleteDeviceConfig(deviceCardEntity);
        return new ResponseEntity<>("configurations for device removed successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Returns an ordered result of devices available for sale", response = DeviceCardEntity.class, responseContainer = "List")
    @RequestMapping(method = RequestMethod.GET, value = "/afs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DeviceCardEntity>> getAllAvialbleForSaleDevices() {
        return new ResponseEntity<>(deviceCardServiceContarct.getAllAvialbleForSaleDevices(), HttpStatus.OK);

    }
}
