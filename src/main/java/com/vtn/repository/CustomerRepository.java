package com.vtn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vtn.model.customer.Customer;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsByPhone(String phone);

    boolean existsByEmail(String email);

    Customer findByIdAndPassword(int id, String password);

    Customer findByPhoneAndPasswordOrEmailAndPassword(String phone, String password, String email, String passwordd);

    Customer findByEmail(String email);

    @Query(value = "select Name from Customer where CustomerId=?", nativeQuery = true)
    String getCustomerName(int customerId);

    Customer findByPhone(String phone);
}
