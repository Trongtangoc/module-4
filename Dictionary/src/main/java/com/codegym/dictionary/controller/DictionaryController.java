package com.codegym.dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {

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

    @GetMapping("/")
    public String home() {
        return "index"; // trả về trang index.jsp
    }

    @PostMapping("/search")
    public String search(@RequestParam("word") String word, Model model) {
        String meaning = dictionary.get(word.toLowerCase());
        if (meaning != null) {
            model.addAttribute("word", word);
            model.addAttribute("meaning", meaning);
        } else {
            model.addAttribute("notFound", "Không tìm thấy từ '" + word + "' trong từ điển.");
        }
        return "index";
    }
}
