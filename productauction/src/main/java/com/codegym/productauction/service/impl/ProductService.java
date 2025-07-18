package com.codegym.productauction.service.impl;

import com.codegym.productauction.model.Product;
import com.codegym.productauction.repository.IProductRepository;
import com.codegym.productauction.repository.ProductRepository;
import com.codegym.productauction.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository repo = new ProductRepository();

    @Override
    public List<Product> findAll(String name, Long price, Integer typeId, int page, int pageSize) {
        int offset = page * pageSize;
        return repo.findAll(name, price, typeId, offset, pageSize);
    }

    @Override
    public int countAll(String name, Long price, Integer typeId) {
        return repo.countAll(name, price, typeId);
    }

    @Override
    public void save(Product product) {
        repo.save(product);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        repo.deleteByIds(ids);
    }

    @Override
    public Product findById(Integer id) {
        return repo.findById(id);
    }
}
