package com.codegym.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping("/show")
    public String index() {
        return "home";
    }

    @RequestMapping("/save")
    public String calculate(
            @RequestParam("num1") Float num1,
            @RequestParam("num2") Float num2,
            @RequestParam("action") String action,
            Model model) {
        Float result = 0.0f;
        if (action.equals("add")) {
            result = num1 + num2;
        }  if (action.equals("sub")) {
            result = num1 - num2;
        }  if (action.equals("mul")) {
            result = num1 * num2;
        }  if (action.equals("dev")) {
            result = num1 / num2;
        }
        model.addAttribute("result", result);
        return "result";
    }


}
