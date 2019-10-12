package com.vtn.model;

import javax.persistence.*;

@Entity
@Table(name = "FCM")
public class FCM {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;
    @Column(name = "CustomerId")
    private int customerId;
    @Column(name = "DeviceId")
    private String deviceId;
    @Column(name = "Token")
    private String token;

    public FCM() {
    }

    public FCM(String deviceId, String token) {
        this.deviceId = deviceId;
        this.token = token;
    }

    public FCM(int customerId, String deviceId, String token) {
        this.customerId = customerId;
        this.deviceId = deviceId;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
