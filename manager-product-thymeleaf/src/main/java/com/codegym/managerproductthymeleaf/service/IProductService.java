package com.codegym.managerproductthymeleaf.service;

import com.codegym.managerproductthymeleaf.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    void saveProduct(Product product);
    Product getProductById(int productId);
    void updateProduct(int productId, Product product);
    void deleteProduct(int productId);
    Product searchProductByName(String productName);
    Product searchProductByCategory(String category);
    Product searchProductByPrice(int price);

}
