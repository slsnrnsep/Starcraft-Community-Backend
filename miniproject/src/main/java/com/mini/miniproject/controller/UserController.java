package com.mini.miniproject.controller;

import com.mini.miniproject.dto.UserDto;
import com.mini.miniproject.model.Comment;
import com.mini.miniproject.security.UserDetailsImpl;
import com.mini.miniproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/user/signup") // 회원가입.
    public String registerUser(@RequestBody UserDto requestDto) {
        userService.registerUser(requestDto);
        return "index.html";
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/api/checklogin")
    public Boolean getComment(@AuthenticationPrincipal UserDetailsImpl userDetails)
    {
        if (userDetails != null)
            return true;
        return false;
    }
//    @PostMapping("/user/login")
//    public
}
