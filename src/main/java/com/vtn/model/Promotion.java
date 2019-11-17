package com.vtn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Promotion")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PromotionId")
    private int promotionId;
    @Column(name = "PromotionName")
    private String promotionName;
    @Column(name = "PromotionPercent")
    private String promotionPercent;
    @Column(name = "StartTime")
    private String startTime;
    @Column(name = "EndTime")
    private String endTime;
    @Column(name = "PromotionImage")
    private String promotionImage;
    @Column(name = "PromotionCode")
    private String promotionCode;
    @Column(name = "MaxPrice")
    private String maxPrice;
    @Column(name = "CategoryId")
    private String categoryId;

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public String getPromotionPercent() {
        return promotionPercent;
    }

    public void setPromotionPercent(String promotionPercent) {
        this.promotionPercent = promotionPercent;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPromotionImage() {
        return promotionImage;
    }

    public void setPromotionImage(String promotionImage) {
        this.promotionImage = promotionImage;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
