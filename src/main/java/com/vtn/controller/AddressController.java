package com.vtn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vtn.model.address.Address;
import com.vtn.model.address.District;
import com.vtn.model.address.Province;
import com.vtn.model.address.Village;
import com.vtn.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addSer;

    @GetMapping("/province")
    public List<Province> getListProvinces() {
        return addSer.getListProvinces();
    }

    @GetMapping("/district")
    public List<District> getListDistricts(@RequestParam String id) {
        return addSer.getListDistricts(id);
    }

    @GetMapping("/village")
    public List<Village> getListVillages(@RequestParam String id) {
        return addSer.getListVillages(id);
    }

    @GetMapping("/list")
    public List<Address> getListAddress(@RequestParam String id) {
        return addSer.getListAddress(id);
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertAddress(@RequestBody Address address) {
        if (addSer.insertAddress(address)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAddress(@RequestBody Address address) {
        if (addSer.deleteAddress(address)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAddress(@RequestBody Address address) {
        System.out.println(address.getStatus() + "");
        if (addSer.updateAddress(address)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
