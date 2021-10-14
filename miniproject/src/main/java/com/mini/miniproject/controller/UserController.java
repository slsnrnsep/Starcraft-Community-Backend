package com.mini.miniproject.controller;

import com.mini.miniproject.dto.UserDto;
import com.mini.miniproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @CrossOrigin(origins = "http://localhost:9999")
    @PostMapping("/user/signup") // 회원가입.
    public String registerUser(@RequestBody UserDto requestDto) {
        userService.registerUser(requestDto);
        return "index.html";
    }
}
