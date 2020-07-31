package com.vtn.model.product;

public class ProductTemp {
    private int productId;
    private int categoryId;
    private String amount;
    private String priceSale;
    private String total;
    private Product product;

    public ProductTemp() {
    }

    public ProductTemp(int productId, int categoryId, String amount, String priceSale, String total, Product product) {
        this.categoryId = categoryId;
        this.amount = amount;
        this.priceSale = priceSale;
        this.total = total;
        this.product = product;
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(String priceSale) {
        this.priceSale = priceSale;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ProductTemp{" +
                "productId=" + productId +
                ", categoryId=" + categoryId +
                ", amount='" + amount + '\'' +
                ", priceSale='" + priceSale + '\'' +
                ", total='" + total + '\'' +
                ", product=" + product +
                '}';
    }
}
