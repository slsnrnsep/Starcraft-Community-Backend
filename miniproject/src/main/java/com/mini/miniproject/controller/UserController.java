package com.mini.miniproject.controller;

import com.mini.miniproject.model.UserDto;
import com.mini.miniproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    @PostMapping("/user/signup") // 회원가입.
    public String registerUser(@RequestBody UserDto requestDto) {
        userService.registerUser(requestDto);
        //중복된 닉네임일경우 처리해줘야함
        return "redirect:/user/login";
    }
}
