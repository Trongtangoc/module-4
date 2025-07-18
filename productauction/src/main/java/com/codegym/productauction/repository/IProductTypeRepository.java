package com.codegym.productauction.repository;

import com.codegym.productauction.model.ProductType;
import java.util.List;

public interface IProductTypeRepository {
    List<ProductType> findAll();
    ProductType findById(Integer id);
}
