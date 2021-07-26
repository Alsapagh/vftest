package com.vodafone.vftest.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * 7/25/2021
 * CREATED BY @Ayman Alsapagh
 **/
public class DeviceCardEntityPK implements Serializable {
    private Integer simId;
    private Integer operatorCode;

//    public DeviceCardEntityPK(Integer simId, Integer operatorCode) {
//        this.simId = simId;
//        this.operatorCode = operatorCode;
//    }

    @Id
    @Column(name = "SIM_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SIM_SEQ")
    @SequenceGenerator(sequenceName = "SIM_SEQ", allocationSize = 1, name = "SIM_SEQ")

    public Integer getSimId() {
        return simId;
    }

    public void setSimId(Integer simId) {
        this.simId = simId;
    }

    @Id
    @Column(name = "OPERATOR_CODE")
    public Integer getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(Integer operatorCode) {
        this.operatorCode = operatorCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceCardEntityPK that = (DeviceCardEntityPK) o;
        return Objects.equals(simId, that.simId) &&
                Objects.equals(operatorCode, that.operatorCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(simId, operatorCode);
    }

}
