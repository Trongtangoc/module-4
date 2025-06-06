package com.codegym.managerproductthymeleaf2.controller;


import com.codegym.managerproductthymeleaf2.model.Product;
import com.codegym.managerproductthymeleaf2.service.IProductService;
import com.codegym.managerproductthymeleaf2.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping("")
    public String index(Model model) {
        List<Product> productsList = productService.getAllProducts();
        model.addAttribute("products", productsList);
        return "/index";
    }

}
