package com.vtn.model.oder;

import javax.persistence.*;

@Entity
@Table(name = "OrderStatus")
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "StatusId")
    private int statusId;
    @Column(name = "StatusDescrip")
    private String statusDescrip;
    @Column(name = "Note")
    private String note;
    @Column(name = "OrderImage")
    private String orderImage;

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusDescrip() {
        return statusDescrip;
    }

    public void setStatusDescrip(String statusDescrip) {
        this.statusDescrip = statusDescrip;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(String orderImage) {
        this.orderImage = orderImage;
    }
}
