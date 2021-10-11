package com.mini.miniproject.controller;

import com.mini.miniproject.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    @GetMapping("/test")
    public String test2(@AuthenticationPrincipal UserDetailsImpl userDetails)
    {
        System.out.println("왐");
        return "index.html";
    }
}
