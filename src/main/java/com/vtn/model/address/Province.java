package com.vtn.model.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Province")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ProvinceId")
    private String provinceId;
    @Column(name = "ProvinceName")
    private String provinceName;
    @Column(name = "Type")
    private String type;

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
