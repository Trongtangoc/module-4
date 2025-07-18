package com.codegym.productauction.service.impl;

import com.codegym.productauction.model.ProductType;
import com.codegym.productauction.repository.IProductTypeRepository;
import com.codegym.productauction.repository.ProductTypeRepository;
import com.codegym.productauction.service.IProductTypeService;
import java.util.List;

public class ProductTypeService implements IProductTypeService {
    private IProductTypeRepository repo = new ProductTypeRepository();

    @Override
    public List<ProductType> findAll() { return repo.findAll(); }

    @Override
    public ProductType findById(Integer id) { return repo.findById(id); }
}
