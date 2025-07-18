package com.codegym.controlauction.service;

import com.codegym.controlauction.model.ProductType;
import java.util.List;

public interface IProductTypeService {
    List<ProductType> findAll();
    ProductType findById(Integer id);
}
