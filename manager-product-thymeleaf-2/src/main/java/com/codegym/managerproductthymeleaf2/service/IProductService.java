package com.codegym.managerproductthymeleaf2.service;

import com.codegym.managerproductthymeleaf2.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    void saveProduct(Product product);
    void deleteProduct(int productId);
    void updateProduct(int productId, Product product);
    Product getProductById(int productId);
}
