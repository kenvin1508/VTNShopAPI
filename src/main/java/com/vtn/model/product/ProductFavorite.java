package com.vtn.model.product;

import javax.persistence.*;

@Entity
@Table(name = "ProductFavorite")
public class ProductFavorite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FavoriteId")
    private int favoriteId;
    @Column(name = "ProductId")
    private int productId;
    @Column(name = "CustomerId")
    private int customerId;
    @Column(name = "Status")
    private boolean status;
    @Transient
    private Product product;

    public int getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(int favoriteId) {
        this.favoriteId = favoriteId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCustomerID() {
        return customerId;
    }

    public void setCustomerID(int customerId) {
        this.customerId = customerId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
