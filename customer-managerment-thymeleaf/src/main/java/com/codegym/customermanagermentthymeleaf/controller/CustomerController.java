package com.codegym.customermanagermentthymeleaf.controller;

import com.codegym.customermanagermentthymeleaf.model.Customer;
import com.codegym.customermanagermentthymeleaf.service.CustomerService;
import com.codegym.customermanagermentthymeleaf.service.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final ICustomerService customerService = new CustomerService();

    @GetMapping("")
    public String index(Model model) {
        List<Customer> customerList = customerService.findAllCustomers();
        model.addAttribute("customers", customerList);
        return "/index";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Customer customer) {
        customer.setCustomerId((int) (Math.random() * 10000));
        customerService.saveCustomer(customer);
        return "redirect:/customer";
    }
    @GetMapping("/{customerId}/edit")
    public String update(@PathVariable int customerId, Model model) {
        model.addAttribute("customer", customerService.findCustomerById(customerId));
        return "/update";
    }

    @PostMapping("/update")
    public String update(Customer customer) {
        customerService.updateCustomer(customer.getCustomerId(), customer);
        return "redirect:/customers";
    }
    @GetMapping("/{customerId}/delete")
    public String delete(@PathVariable int customerId, Model model) {
        model.addAttribute("customer", customerService.findCustomerById(customerId));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.deleteCustomer(customer.getCustomerId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customers";
    }

    @GetMapping("/{customerId}/view")
    public String view(@PathVariable int customerId, Model model) {
        model.addAttribute("customer", customerService.findCustomerById(customerId));
        return "/view";
    }
}