package com.vtn.model.product;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ProductId")
    private int productId;
    @Column(name = "CategoryId")
    private int categoryId;
    @Column(name = "ProductName")
    private String productName;
    @Column(name = "ProductPrice")
    private String productPrice;
    @Column(name = "PercentSale")
    private String percentSale;
    @Column(name = "PriceSale")
    private String priceSale;
    @Column(name = "Amount")
    private String amount;
    @Column(name = "Description")
    private String description;
    @Column(name = "ProductImage")
    private String productImage;
    @Column(name = "Status")
    private boolean status;
    @Transient
    private List<String> productImages;

    public List<String> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<String> productImages) {
        this.productImages = productImages;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getPercentSale() {
        return percentSale;
    }

    public void setPercentSale(String percentSale) {
        this.percentSale = percentSale;
    }

    public String getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(String priceSale) {
        this.priceSale = priceSale;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", categoryId=" + categoryId +
                ", productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", percentSale='" + percentSale + '\'' +
                ", priceSale='" + priceSale + '\'' +
                ", amount='" + amount + '\'' +
                ", description='" + description + '\'' +
                ", productImage='" + productImage + '\'' +
                ", status=" + status +
                ", productImages=" + productImages +
                '}';
    }
}
