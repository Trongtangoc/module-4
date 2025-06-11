package com.codegym.managerproductthymeleaf2.service;

import com.codegym.managerproductthymeleaf2.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone", "Best Selling Phone", 20000, "Apple", "Image", 500, "SmartPhone"));
        products.put(2, new Product(2, "Xiaomi", "Best Selling Phone", 22000, "Apple", "Image", 200, "SmartPhone"));
        products.put(3, new Product(3, "Ipad", "Best Selling Phone", 21000, "Apple", "Image", 100, "Tablet"));
        products.put(4, new Product(4, "SamSung", "Best Selling Phone", 26000, "Apple", "Image", 300, "SmartPhone"));
        products.put(5, new Product(5, "Nokia", "Best Selling Phone", 27000, "Apple", "Image", 400, "SmartPhone"));
        products.put(6, new Product(6, "Iphone16", "Best Selling Phone", 28000, "Apple", "Image", 900, "SmartPhone"));
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
    public void deleteProduct(int productId) {
        products.remove(productId);
    }

    @Override
    public void updateProduct(int productId, Product product) {
        products.put(productId, product);
    }

    @Override
    public Product getProductById(int productId) {
        return products.get(productId);
    }
}
