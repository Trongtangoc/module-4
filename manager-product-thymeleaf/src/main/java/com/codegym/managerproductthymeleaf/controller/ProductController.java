package com.codegym.managerproductthymeleaf.controller;

import com.codegym.managerproductthymeleaf.model.Product;
import com.codegym.managerproductthymeleaf.service.IProductService;
import com.codegym.managerproductthymeleaf.service.ProductService;
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
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("products", productList);
        return "index";
    }

}
