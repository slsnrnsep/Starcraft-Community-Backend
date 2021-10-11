package com.mini.miniproject.controller;

import com.mini.miniproject.dbSet.SetTestDb;
import com.mini.miniproject.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class HomeController {
    private final SetTestDb  setTestDb;
    private Boolean a = true;
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
    @GetMapping("/dbSet")
    public void test33()
    {
        if (a) {
            a = false;
            setTestDb.dbset();
        }
    }
}
