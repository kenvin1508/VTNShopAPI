package com.vtn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vtn.model.address.Address;
import com.vtn.model.address.District;
import com.vtn.model.address.Province;
import com.vtn.model.address.Village;

@Repository
public interface AddressRepository {

    interface ProvinceRepository extends JpaRepository<Province, Integer> {
        @Query(value = "select ProvinceName from Province where ProvinceId =?1", nativeQuery = true)
        String getProvinceName(String id);
    }

    interface DistrictRepository extends JpaRepository<District, Integer> {
        List<District> findByProvinceId(String provinceId);

        @Query(value = "select DistrictName from District where DistrictId =?1", nativeQuery = true)
        String getDistrictName(String id);
    }

    interface VillageRepository extends JpaRepository<Village, Integer> {
        List<Village> findByDistrictId(String districtId);

        @Query(value = "select VillageName from Village where VillageId =?1", nativeQuery = true)
        String getVillageName(String id);

    }

    interface CustomerAdressRepository extends JpaRepository<Address, Integer> {
        List<Address> findByCustomerIdAndStatusTrue(String customerId);

        @Query(value = "select AddressDescrip from Address where AddressId =?1", nativeQuery = true)
        String addressDescrip(String addressId);

        Address findAddressByAddressId(String addressId);
    }

}
