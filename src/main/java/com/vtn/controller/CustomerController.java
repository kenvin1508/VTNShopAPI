package com.vtn.controller;

import java.util.Optional;

import com.vtn.model.FCM;
import com.vtn.service.FCMServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.vtn.model.customer.Customer;
import com.vtn.model.customer.Password;
import com.vtn.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService cusSer;
    @Autowired
    FCMServices fcmSer;

    @GetMapping("/getone")
    public Optional<Customer> getOne(@RequestParam int id) {
        return cusSer.getCustomer(id);
    }

    @PostMapping("/checksignup")
    public String checkSignUp(@RequestBody Customer customer) {
        System.out.println(customer.getPhone());
        if (cusSer.existsByPhone(customer.getPhone())) {
            return "phone";
        }
        if (cusSer.existsByEmail((customer.getEmail()))) {
            return "email";
        }
        return "success";
    }

    @PostMapping("/insert")
    public String insertCustomer(@RequestBody Customer customer) {
        try {
            cusSer.save(customer);
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        Customer customerN = cusSer.update(customer);
        if (customerN != null) {
            return new ResponseEntity<>(customerN, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/chagepass")
    public String changePass(@RequestBody Password password) {
        if (cusSer.changePassword(password)) {
            return "success";
        } else {
            return "fail";
        }
    }


    @PostMapping("/login")
    public ResponseEntity<Customer> getAll(@RequestBody Customer customer
            , @RequestParam String deviceId, @RequestParam String token) {
        Customer customerN = cusSer.login(customer);
        if (customerN != null) {
            FCM fcm = fcmSer.checkExistFCM(deviceId, token);
            if (fcm == null) {
                fcmSer.insertLogin(new FCM(customerN.getId(), deviceId, token));
            } else {
                fcm.setCustomerId(customerN.getId());
                fcmSer.insertLogin(fcm);
            }
            return new ResponseEntity<>(customerN, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/logout")
    public void logout(@RequestParam int customerId
            , @RequestParam String deviceId, @RequestParam String token) {
        fcmSer.getFCMLogout(customerId, deviceId, token);
    }

    @GetMapping("/checkexistfb")
    public ResponseEntity<Customer> checkExistFB(@RequestParam String email) {
        if (cusSer.checkExistFB(email) != null) {
            return new ResponseEntity<>(cusSer.checkExistFB(email), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping("/checkexistphone")
    public String checkExistPhone(@RequestParam String phone) {
        if (cusSer.existsByPhone(phone)) {
            return "existed";
        } else {
            return "done";
        }

    }

    @PostMapping("/loginfb")
    public ResponseEntity<Customer> loginFb(@RequestBody Customer customer
            , @RequestParam String idAccount
            , @RequestParam String urlImage) {
        Customer customer1 = cusSer.loginFB(customer, idAccount, urlImage);
        return new ResponseEntity<>(customer1, HttpStatus.OK);
    }

    @PutMapping("/forgot_password")
    public void forgotPassword(@RequestParam String phone, @RequestParam String newPassword) {
        cusSer.forgotPassword(phone, newPassword);
    }
}
