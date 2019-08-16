package com.vtn.model;

public class OutOfStock {
    private int productId;
    private int cartId;

    public OutOfStock(int productId, int cartId) {
        this.productId = productId;
        this.cartId = cartId;
    }

    public OutOfStock() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
}
