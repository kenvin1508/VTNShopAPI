package com.vtn.model.address;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AddressId")
    private String addressId;
    @Column(name = "CustomerId")
    private String customerId;
    @Column(name = "ProvinceId")
    private String provinceId;
    @Column(name = "DistrictId")
    private String districtId;
    @Column(name = "VillageId")
    private String villageId;
    @Column(name = "AddressDescrip")
    private String addressDescrip;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Name")
    private String name;
    @Column(name = "Status")
    private boolean status;
    private String provinceName;
    private String districtName;
    private String villageName;
    private String numberAddress;

    public String getNumberAddress() {
        return numberAddress;
    }

    public void setNumberAddress(String numberAddress) {
        this.numberAddress = numberAddress;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getVillageId() {
        return villageId;
    }

    public void setVillageId(String villageId) {
        this.villageId = villageId;
    }

    public boolean isStatus() {
        return status;
    }

    public String getAddressDescrip() {
        return addressDescrip;
    }

    public void setAddressDescrip(String addressDescrip) {
        this.addressDescrip = addressDescrip;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", customerId='" + customerId + '\'' +
                ", provinceId='" + provinceId + '\'' +
                ", districtId='" + districtId + '\'' +
                ", villageId='" + villageId + '\'' +
                ", addressDescrip='" + addressDescrip + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", provinceName='" + provinceName + '\'' +
                ", districtName='" + districtName + '\'' +
                ", villageName='" + villageName + '\'' +
                ", numberAddress='" + numberAddress + '\'' +
                '}';
    }
}
