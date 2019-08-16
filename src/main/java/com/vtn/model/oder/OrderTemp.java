package com.vtn.model.oder;


import com.vtn.model.product.ProductTemp;

import java.util.ArrayList;

public class OrderTemp {
    private int orderId;
    private int customerId;
    private int statusId;
    private int paymentFormId;
    private String createdDate;
    private String paymentFormName;
    private String total;
    private String phone;
    private String addressId;
    private String note;
    private String customerName;
    private String customerAddress;
    private String statusDescrip;
    private ArrayList<ProductTemp> products;

    public OrderTemp(int orderId, String createdDate, String statusDescrip, String customerAddress, String phone, String customerName, String total, String paymentFormName) {
        this.orderId = orderId;
        this.createdDate = createdDate;
        this.statusDescrip = statusDescrip;
        this.customerAddress = customerAddress;
        this.phone = phone;
        this.customerName = customerName;
        this.total = total;
        this.paymentFormName = paymentFormName;
    }

    public String getPaymentFormName() {
        return paymentFormName;
    }

    public void setPaymentFormName(String paymentFormName) {
        this.paymentFormName = paymentFormName;
    }

    public int getPaymentFormId() {
        return paymentFormId;
    }

    public void setPaymentFormId(int paymentFormId) {
        this.paymentFormId = paymentFormId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getStatusDescrip() {
        return statusDescrip;
    }

    public void setStatusDescrip(String statusDescrip) {
        this.statusDescrip = statusDescrip;
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
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public ArrayList<ProductTemp> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductTemp> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "OrderTemp{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", statusId=" + statusId +
                ", createdDate='" + createdDate + '\'' +
                ", total='" + total + '\'' +
                ", phone='" + phone + '\'' +
                ", addressId='" + addressId + '\'' +
                ", note='" + note + '\'' +
                ", products=" + products +
                '}';
    }
}

