package com.vtn.model.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "District")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DistrictId")
    private String districtId;
    @Column(name = "DistrictName")
    private String districtName;
    @Column(name = "Type")
    private String type;
    @Column(name = "ProvinceId")
    private String provinceId;


    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }
}


