package com.vtn.model.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Village")
public class Village {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VillageId")
    private String villageId;
    @Column(name = "VillageName")
    private String villageName;
    @Column(name = "Type")
    private String type;
    @Column(name = "DistrictId")
    private String districtId;

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVillageId() {
        return villageId;
    }

    public void setVillageId(String villageId) {
        this.villageId = villageId;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }
}
