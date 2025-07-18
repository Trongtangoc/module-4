package com.codegym.controlauction.repository;

import com.codegym.controlauction.model.ProductType;
import java.util.List;

public interface IProductTypeRepository {
    List<ProductType> findAll();
    ProductType findById(Integer id);
}
