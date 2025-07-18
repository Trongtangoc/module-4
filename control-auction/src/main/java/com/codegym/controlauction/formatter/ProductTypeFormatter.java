package com.codegym.controlauction.formatter;

import com.codegym.controlauction.model.ProductType;
import com.codegym.controlauction.service.IProductTypeService;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class ProductTypeFormatter implements Formatter<ProductType> {

    private IProductTypeService service;

    public ProductTypeFormatter(IProductTypeService service) { this.service = service; }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        return service.findById(Integer.valueOf(text));
    }

    @Override
    public String print(ProductType object, Locale locale) {
        return String.valueOf(object.getCid());
    }
}
