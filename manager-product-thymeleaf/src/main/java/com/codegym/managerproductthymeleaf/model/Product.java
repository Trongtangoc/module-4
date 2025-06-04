package com.codegym.managerproductthymeleaf.model;

public class Product {
    private int productId;
    private String productName;
    private String productDescription;
    private int productPrice;
    private String productCategory;
    private String productImage;
    private String productStatus;

    private String productBrand;
    private int productQuantity;
    private String productUnit;


    public Product() {

    }

    public Product(int productId, String productName, String productDescription, int productPrice, String productCategory, String productImage, String productStatus,  String productBrand, int productQuantity, String productUnit) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productImage = productImage;
        this.productStatus = productStatus;
        this.productBrand = productBrand;
        this.productQuantity = productQuantity;
        this.productUnit = productUnit;
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

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }


    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }
}
