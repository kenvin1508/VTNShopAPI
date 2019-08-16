package com.vtn.model.oder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "[Order]")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OrderId")
    private int orderId;
    @Column(name = "CustomerId")
    private int customerId;
    @Column(name = "StatusId")
    private int statusId;
    @Column(name = "PaymentFormId")
    private int paymentFormId;
    @Column(name = "CreatedDate")
    private String createdDate;
    @Column(name = "Total")
    private String total;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "AddressId")
    private String AddressId;
    @Column(name = "Note")
    private String note;
    //  @Column(name = "products", nullable = true)
//    private ArrayList<Product> products;
//
//    public ArrayList<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(ArrayList<Product> products) {
//        this.products = products;
//    }


    public int getPaymentFormId() {
        return paymentFormId;
    }

    public void setPaymentFormId(int paymentFormId) {
        this.paymentFormId = paymentFormId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressId() {
        return AddressId;
    }

    public void setAddressId(String addressId) {
        AddressId = addressId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", statusId=" + statusId +
                ", paymentFormId=" + paymentFormId +
                ", createdDate='" + createdDate + '\'' +
                ", total='" + total + '\'' +
                ", phone='" + phone + '\'' +
                ", AddressId='" + AddressId + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
