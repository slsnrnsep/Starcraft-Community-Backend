package com.mini.miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String test()
    {
        System.out.println("왐");
        return "index.html";
    }
}
