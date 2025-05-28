package com.codegym.dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/home")
public class DictionaryController {
    @RequestMapping("/show")
    public String showHome() {
        return "home";
    }

    // Dữ liệu từ điển Anh - Việt
    private static final Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("book", "quyển sách");
        dictionary.put("computer", "máy tính");
        dictionary.put("car", "xe hơi");
        dictionary.put("dog", "con chó");
        // ... thêm từ nếu muốn
    }

    @RequestMapping("/search")
    public String search(@RequestParam("search") String search, Model model) {
        String meaning = dictionary.get(search.toLowerCase());
        if (meaning != null) {
            model.addAttribute("search", search);
            model.addAttribute("meaning", meaning);
        } else {
            model.addAttribute("notFound", "Không tìm thấy từ '" + search + "' trong từ điển.");
        }
        return "result";
    }
}
