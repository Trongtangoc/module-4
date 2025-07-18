package com.codegym.controlauction.repository;

import com.codegym.controlauction.model.Product;
import java.util.List;

public interface IProductRepository {
    List<Product> findAll(String name, Long price, Integer typeId, int offset, int limit);
    int countAll(String name, Long price, Integer typeId);
    void save(Product product);
    void deleteByIds(List<Integer> ids);
    Product findById(Integer id);
}
