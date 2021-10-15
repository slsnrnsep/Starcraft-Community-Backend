package com.mini.miniproject.controller;

import com.mini.miniproject.dto.UserDto;
import com.mini.miniproject.model.Comment;
import com.mini.miniproject.model.User;
import com.mini.miniproject.security.UserDetailsImpl;
import com.mini.miniproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/loginfail") // login fail
    public Boolean loginfail()
    {
        return false;
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/loginsuccess/{username}") // login suc
    public UserDto loginsuccess(@PathVariable String username)
    {
        User user = userService.find(username);
        UserDto ud = new UserDto();
        ud.setUserNick(user.getUserNick());
        ud.setId(user.getId());
        if (user!= null)
            return  ud;
        return null;
    }

}
