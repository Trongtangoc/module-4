package com.codegym.managerproductthymeleaf.service;

import com.codegym.managerproductthymeleaf.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone", "Smart Phone Best Selling", 20000000, "SmartPhone", "Image", "In Stock", "Apple", 1000, "Chiec"));
        products.put(2, new Product(2, "SamSung", "Smart Phone Best Selling", 30000000, "Tablet", "Image", "In Stock", "SamSung", 8000, "Chiec"));
        products.put(3, new Product(3, "Xiaomi", "Smart Phone Best Selling", 40000000, "SmartPhone", "Image", "In Stock", "Xiaomi", 7000, "Chiec"));
        products.put(4, new Product(4, "Huwei", "Smart Phone Best Selling", 50000000, "SmartPhone", "Image", "In Stock", "Huwei", 5000, "Chiec"));
        products.put(5, new Product(5, "Opple", "Smart Phone Best Selling", 15000000, "SmartPhone", "Image", "In Stock", "Opple", 5000, "Chiec"));
        products.put(6, new Product(6, "Nokia", "Smart Phone Best Selling", 19000000, "SmartPhone", "Image", "In Stock", "Nokia", 11000, "Chiec"));
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void saveProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    @Override
    public Product getProductById(int productId) {
        return products.get(productId);
    }

    @Override
    public void updateProduct(int productId, Product product) {
        products.put(productId, product);
    }

    @Override
    public void deleteProduct(int productId) {
        products.remove(productId);
    }

    @Override
    public Product searchProductByName(String productName) {
        return products.get(productName);
    }

    @Override
    public Product searchProductByCategory(String productCategory) {
        return products.get(productCategory);
    }

    @Override
    public Product searchProductByPrice(int productPrice) {
        return products.get(productPrice);

    }


}
