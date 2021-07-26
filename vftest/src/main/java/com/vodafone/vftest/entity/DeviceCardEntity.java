package com.vodafone.vftest.entity;

import com.vodafone.vftest.enums.Status;

import javax.persistence.*;

/**
 * 7/25/2021
 * CREATED BY @Ayman Alsapagh
 **/
@Entity
@Table(name = "DEVICE_CARD")
@IdClass(DeviceCardEntityPK.class)
public class DeviceCardEntity {

    private Integer simId;
    private Integer operatorCode;
    private String country;
    private Status status;

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

    @Basic
    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
