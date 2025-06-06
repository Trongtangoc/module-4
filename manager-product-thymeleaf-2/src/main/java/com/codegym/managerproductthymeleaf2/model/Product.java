package com.codegym.managerproductthymeleaf2.model;

public class Product {
    private int productId;
    private String productName;
    private String productDescription;
    private int productPrice;
    private String productBrand;
    private String productImage;
    private int productStock;
    private String productType;

    public Product() {

    }

    public Product(int productId, String productName, String productDescription, int productPrice, String productBrand, String productImage, int productStock, String productType) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productBrand = productBrand;
        this.productImage = productImage;
        this.productStock = productStock;
        this.productType = productType;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", productBrand='" + productBrand + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productStock='" + productStock + '\'' +
                ", productType='" + productType + '\'' +
                '}';
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
