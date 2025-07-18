package com.codegym.productauction.service;

import com.codegym.productauction.model.ProductType;
import java.util.List;

public interface IProductTypeService {
    List<ProductType> findAll();
    ProductType findById(Integer id);
}
