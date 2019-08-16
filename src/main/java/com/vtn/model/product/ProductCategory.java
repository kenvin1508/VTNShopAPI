package com.vtn.model.product;

import javax.persistence.*;

@Entity
@Table(name = "ProductCategory")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CategoryId")
    private int categoryId;
    @Column(name = "CategoryName")
    private String categoryName;
    @Column(name = "CategoryImage")
    private String categoryImage;
    @Column(name = "PromotionId")
    private int promotionId;


    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

}
