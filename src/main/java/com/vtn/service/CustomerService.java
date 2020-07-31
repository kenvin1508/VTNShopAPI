package com.vtn.service;

import com.vtn.model.customer.Customer;
import com.vtn.model.customer.Password;
import com.vtn.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository cusRes;

    public Optional<Customer> getCustomer(int id) {
        return cusRes.findById(id);
    }

    public void save(Customer customer) {
        System.out.println(customer.toString());
        cusRes.save(customer);
    }

    public boolean existsByPhone(String phone) {
        return cusRes.existsByPhone(phone);
    }

    public boolean existsByEmail(String email) {
        return cusRes.existsByEmail(email);
    }

    public Customer update(Customer customer) {
        Customer customerU = cusRes.findById(customer.getId()).get();

        customerU.setName(customer.getName());
        customerU.setDateOfBirth(customer.getDateOfBirth());
        customerU.setGender(customer.getGender());
        customerU.setImage(customer.getImage());

        return cusRes.save(customerU);

    }

    public boolean changePassword(Password password) {
        Customer customer = cusRes.findByIdAndPassword(password.getCustomerId(), password.getOldPassword());
        if (customer != null) {
            customer.setPassword(password.getNewPassword());
            cusRes.save(customer);
            return true;
        } else {
            return false;
        }
    }

    public Customer login(Customer customer) {
        String email = null;
        String phone = null;
        String password = customer.getPassword();
        if (customer.getEmail() != null) {
            email = customer.getEmail();
        } else if (customer.getPhone() != null) {
            phone = customer.getPhone();
        }
        return cusRes.findByPhoneAndPasswordOrEmailAndPassword(phone, password, email, password);
    }

    public Customer checkExistFB(String email) {
        if (cusRes.existsByEmail(email)) {
            Customer customer = cusRes.findByEmail(email);
            return customer;
        } else {
            return null;
        }
    }

    public Customer loginFB(Customer customer, String idAccount, String urlImage) {
        String absolutePath = new File("") // Get AbsolutePath of Windows
                .getAbsolutePath()
                .replace("\\", "/");
        String customerPath = absolutePath + "/src/main/resources/static/images/customer/";
        String imagePath = customerPath + idAccount + ".png";
        // if (cusRes.existsByEmail(customer.getEmail())) {
        //     Customer customer1 = cusRes.findByEmail(customer.getEmail());
        //     return new ResponseEntity<>(customer1, HttpStatus.OK);

        // } else {
        try (InputStream in = new URL(urlImage).openStream()) {
            Files.deleteIfExists(Paths.get(imagePath)); // check if existed delete
            Files.copy(in, Paths.get(imagePath));// add new image to file
        } catch (IOException e) {
            e.printStackTrace();
        }

        customer.setImage("/images/customer/" + idAccount + ".png");
        customer.setGender("Nam");
        customer.setDateOfBirth(customer.getCreatedDate());
        Customer customer1 = cusRes.save(customer);
        return customer1;
        //  }
    }

    public void forgotPassword(String phone, String newPassword) {
        phone = "0" + phone.substring(3);
        System.out.println(phone);
        Customer customer = cusRes.findByPhone(phone);
        customer.setPassword(newPassword);
        cusRes.save(customer);
    }

}
