package com.vtn.service;

import com.vtn.model.FCM;
import com.vtn.repository.FCMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FCMServices {
    @Autowired
    FCMRepository fcmRep;

    public FCM checkExistFCM(String deviceId, String token) {
        FCM fcm = fcmRep.findByDeviceIdAndToken(deviceId, token);
        if (fcm != null) {
            return fcm;
        }
        return null;
    }

    public void getFCMLogout(int customerId, String deviceId, String token) {
        FCM fcm = fcmRep.findByCustomerIdAndDeviceIdAndToken(customerId, deviceId, token);
        fcm.setCustomerId(0);
        fcmRep.save(fcm);
    }

    public void insertLogin(FCM fcm) {
        fcmRep.save(fcm);
    }

    public void insert(String deviceId, String token) {
        if (fcmRep.findByDeviceIdAndToken(deviceId, token) == null) {
            System.out.println("asdasd");
            FCM fcm = new FCM(deviceId, token);
            fcmRep.save(fcm);
        }
    }

    public List<String> getListToken() {
        return fcmRep.getListToken();
    }

    public List<String> getListTokenWithCustomerId(int customerId) {
        return fcmRep.getListTokenWithCustomerId(customerId);
    }
}
