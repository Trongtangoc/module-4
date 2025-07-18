package com.codegym.controlauction.controller;

import com.codegym.controlauction.model.Product;
import com.codegym.controlauction.model.ProductType;
import com.codegym.controlauction.service.IProductService;
import com.codegym.controlauction.service.IProductTypeService;
import com.codegym.controlauction.service.impl.ProductService;
import com.codegym.controlauction.service.impl.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final IProductService productService = new ProductService();
    private final IProductTypeService productTypeService = new ProductTypeService();

    @GetMapping
    public String list(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "price", required = false) Long price,
            @RequestParam(value = "typeId", required = false) Integer typeId,
            @RequestParam(value = "page", defaultValue = "0") int page,
            Model model
    ) {
        int pageSize = 5;
        List<Product> products = productService.findAll(name, price, typeId, page, pageSize);
        int total = productService.countAll(name, price, typeId);

        model.addAttribute("products", products);
        model.addAttribute("total", total);
        model.addAttribute("page", page);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("name", name);
        model.addAttribute("price", price);
        model.addAttribute("typeId", typeId);
        model.addAttribute("productTypes", productTypeService.findAll());
        return "product/list";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("productTypes", productTypeService.findAll());
        return "product/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("product") Product product, Model model) {
        // Validate dữ liệu
        boolean valid = true;
        if (product.getName() == null || product.getName().length() < 5 || product.getName().length() > 50)
            valid = false;
        if (product.getPrice() == null || product.getPrice() < 100000)
            valid = false;
        if (product.getProductType() == null || product.getProductType().getCid() == null)
            valid = false;

        if (!valid) {
            model.addAttribute("error", "Vui lòng nhập đúng định dạng dữ liệu!");
            model.addAttribute("productTypes", productTypeService.findAll());
            return "product/add";
        }
        productService.save(product);
        return "redirect:/product";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("ids") String[] ids) {
        List<Integer> idList = Arrays.stream(ids).map(Integer::parseInt).collect(Collectors.toList());
        productService.deleteByIds(idList);
        return "redirect:/product";
    }
}
