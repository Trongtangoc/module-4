package com.codegym.controlauction.service;

import com.codegym.controlauction.model.Product;
import java.util.List;

public interface IProductService {
    List<Product> findAll(String name, Long price, Integer typeId, int page, int pageSize);
    int countAll(String name, Long price, Integer typeId);
    void save(Product product);
    void deleteByIds(List<Integer> ids);
    Product findById(Integer id);
}
