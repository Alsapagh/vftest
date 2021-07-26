package com.vodafone.vftest.repo;

import com.vodafone.vftest.entity.DeviceCardEntity;
import com.vodafone.vftest.entity.DeviceCardEntityPK;
import com.vodafone.vftest.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 7/25/2021
 * CREATED BY @Ayman Alsapagh
 **/
@Repository
public interface DeviceCardRepo extends JpaRepository<DeviceCardEntity, DeviceCardEntityPK> {
    List<DeviceCardEntity> findAllByStatus(Status status);
}
