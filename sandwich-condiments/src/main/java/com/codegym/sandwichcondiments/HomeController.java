package com.codegym.sandwichcondiments;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class HomeController {
    @RequestMapping("/show")
    public String showHome() {
        return "home";
    }

    @RequestMapping("/save")
    public String saveCondiments(
            @RequestParam(value = "condi1", required = false) String condi1,
            @RequestParam(value = "condi2", required = false) String condi2,
            @RequestParam(value = "condi3", required = false) String condi3,
            @RequestParam(value = "condi4", required = false) String condi4,
//            Model de nhan va save du lieu
            Model model) {
        String message = "";
        if (condi1 != null) {
            message += condi1 + ", ";
        }
        if (condi2 != null) {
            message += condi2 + ", ";
        }
        if (condi3 != null) {
            message += condi3 + ", ";
        }
        if (condi4 != null) {
            message += condi4;

        }
        model.addAttribute("message", message);
        return "result";
    }
}
