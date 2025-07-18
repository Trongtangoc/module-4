package com.codegym.controlauction.service.impl;

import com.codegym.controlauction.model.ProductType;
import com.codegym.controlauction.repository.IProductTypeRepository;
import com.codegym.controlauction.repository.ProductTypeRepository;
import com.codegym.controlauction.service.IProductTypeService;
import java.util.List;

public class ProductTypeService implements IProductTypeService {
    private IProductTypeRepository repo = new ProductTypeRepository();

    @Override
    public List<ProductType> findAll() { return repo.findAll(); }

    @Override
    public ProductType findById(Integer id) { return repo.findById(id); }
}
