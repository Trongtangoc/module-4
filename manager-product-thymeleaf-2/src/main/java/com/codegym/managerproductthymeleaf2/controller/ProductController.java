package com.codegym.managerproductthymeleaf2.controller;


import com.codegym.managerproductthymeleaf2.model.Product;
import com.codegym.managerproductthymeleaf2.service.IProductService;
import com.codegym.managerproductthymeleaf2.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Product product) {
        product.setProductId((int) (Math.random() *  10000));
        productService.saveProduct(product);
        return "redirect:/products";
    }
    @GetMapping("/{productId}/edit")
    public String edit(@PathVariable int productId, Model model) {
        model.addAttribute("product",productService.getProductById(productId));
        return "/update";
    }
    @PostMapping("/update")
    public String update(Product product) {
        productService.updateProduct(product.getProductId(), product);
        return "redirect:/products";
    }
    @GetMapping("/{productId}/delete")
    public String delete(@PathVariable int productId, Model model) {
        model.addAttribute("product",productService.getProductById(productId));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        productService.deleteProduct(product.getProductId());
        redirectAttributes.addFlashAttribute("success", "Product deleted successfully");
        return "redirect:/products";
    }

    @GetMapping("/{productId}/view")
    public String view(@PathVariable int productId, Model model) {
        model.addAttribute("product",productService.getProductById(productId));
        return "/view";
    }
}
