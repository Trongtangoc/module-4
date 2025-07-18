package com.codegym.productauction.repository;

import com.codegym.productauction.model.Product;
import java.util.List;

public interface IProductRepository {
    List<Product> findAll(String name, Long price, Integer typeId, int offset, int limit);
    int countAll(String name, Long price, Integer typeId);
    void save(Product product);
    void deleteByIds(List<Integer> ids);
    Product findById(Integer id);
}
