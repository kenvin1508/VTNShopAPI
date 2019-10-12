package com.vtn.repository;

import com.vtn.model.FCM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FCMRepository extends JpaRepository<FCM, Integer> {
    FCM findByDeviceIdAndToken(String deviceId, String token);


    FCM findByCustomerIdAndDeviceIdAndToken(int customerId, String deviceId, String token);

    @Query(value = "SELECT Token FROM FCM", nativeQuery = true)
    List<String> getListToken();

    @Query(value = "SELECT Token FROM FCM WHERE CustomerId =?1", nativeQuery = true)
    List<String> getListTokenWithCustomerId(int customerId);
}
