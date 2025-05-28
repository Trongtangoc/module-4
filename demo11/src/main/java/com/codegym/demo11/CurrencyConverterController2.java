package com.codegym.demo11;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class CurrencyConverterController2 {
    @RequestMapping("/showform")
    public String showForm(){
        return "convert-form";
    }
    @PostMapping("/convert")
    public String convertCurrency(@RequestParam("rate") double rate,
                                  @RequestParam("usd") double usd,
                                  Model model) {
        double vnd = rate * usd;
        model.addAttribute("rate", rate);
        model.addAttribute("usd", usd);
        model.addAttribute("vnd", vnd);
        return "convert-result";
    }
}
