package com.vtn.model.product;

import javax.persistence.*;

@Entity
@Table(name = "ProductImage")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ImageId")
    private int imageId;
    @Column(name = "ProductId")
    private int productId;
    @Column(name = "ImageURL")
    private int imageURL;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getImageURL() {
        return imageURL;
    }

    public void setImageURL(int imageURL) {
        this.imageURL = imageURL;
    }
}
