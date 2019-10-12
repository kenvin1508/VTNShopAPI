package com.vtn.fcm;

import java.util.List;

public class FCMRequest {
    private String title;
    private String body;
    private String imageURL;
    private String topic;
    private String token;
    private int customerId;
    private int orderId;
    private String orderStatus;
    private List<String> listToken;

    public FCMRequest() {
    }

    public FCMRequest(String title, String body, String topicName) {
        this.title = title;
        this.body = body;
        this.topic = topicName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<String> getListToken() {
        return listToken;
    }

    public void setListToken(List<String> listToken) {
        this.listToken = listToken;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
