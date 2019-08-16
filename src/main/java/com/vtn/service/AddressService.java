package com.vtn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtn.model.address.Address;
import com.vtn.model.address.District;
import com.vtn.model.address.Province;
import com.vtn.model.address.Village;
import com.vtn.repository.AddressRepository;

@Service
public class AddressService {
    @Autowired
    AddressRepository.DistrictRepository disRes;
    @Autowired
    AddressRepository.ProvinceRepository provRes;
    @Autowired
    AddressRepository.VillageRepository villRes;
    @Autowired
    AddressRepository.CustomerAdressRepository cusAddRess;

    public List<Province> getListProvinces() {
        return provRes.findAll();
    }

    public List<District> getListDistricts(String provinceId) {
        return disRes.findByProvinceId(provinceId);
    }

    public List<Village> getListVillages(String districtId) {
        return villRes.findByDistrictId(districtId);
    }

    public String getProvinceName(String id) {
        return provRes.getProvinceName(id);
    }

    public String getDistrictName(String id) {
        return disRes.getDistrictName(id);
    }

    public String getVillageName(String id) {
        return villRes.getVillageName(id);
    }


    public List<Address> getListAddress(String customerId) {
        //        for (Address address : addressList) {
//            address.setProvinceName(getProvinceName(address.getProvinceId()));
//            address.setDistrictName(getDistrictName(address.getDistrictId()));
//            address.setVillageName(getVillageName(address.getVillageId()));
//        }
        return cusAddRess.findByCustomerIdAndStatusTrue(customerId);
    }

    public boolean insertAddress(Address address) {
        try {
            Address addressP = toProcessAddress(address);
            cusAddRess.save(addressP);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Address toProcessAddress(Address address) {
        String provinceName = getProvinceName(address.getProvinceId());
        String districtName = getDistrictName(address.getDistrictId());
        String villageName = getVillageName(address.getVillageId());
        String fullAddress = address.getAddressDescrip() + ", " + provinceName + ", " + districtName + ", " + villageName;
        address.setAddressDescrip(fullAddress);
        address.setProvinceName(provinceName);
        address.setDistrictName(districtName);
        address.setVillageName(villageName);
        return address;
    }

    public boolean deleteAddress(Address address) {
        try {
            address.setStatus(false);
            cusAddRess.save(address);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateAddress(Address address) {
        address = toProcessAddress(address);
        try {
            cusAddRess.save(address);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
