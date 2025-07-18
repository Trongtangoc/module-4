package com.codegym.productauction.service;

import com.codegym.productauction.model.Product;
import java.util.List;

public interface IProductService {
    List<Product> findAll(String name, Long price, Integer typeId, int page, int pageSize);
    int countAll(String name, Long price, Integer typeId);
    void save(Product product);
    void deleteByIds(List<Integer> ids);
    Product findById(Integer id);
}
