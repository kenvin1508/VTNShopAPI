package com.vtn.model;


import com.vtn.model.product.Product;

import java.util.List;

public class Homepage {
    private int categoryId;
    private String categoryName;
    private String categoryPromotionImage;
    private int amountProduct;
    private List<Product> product;

    public Homepage(int categoryId, String categoryName, String categoryPromotionImage, int amountProduct, List<Product> product) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.product = product;
        this.categoryPromotionImage = categoryPromotionImage;
        this.amountProduct = amountProduct;
    }

    public int getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(int amountProduct) {
        this.amountProduct = amountProduct;
    }

    public String getCategoryPromotionImage() {
        return categoryPromotionImage;
    }

    public void setCategoryPromotionImage(String categoryPromotionImage) {
        this.categoryPromotionImage = categoryPromotionImage;
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

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
