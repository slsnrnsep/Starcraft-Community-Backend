package com.mini.miniproject.controller;

import com.mini.miniproject.dto.UserDto;
import com.mini.miniproject.model.Comment;
import com.mini.miniproject.model.User;
import com.mini.miniproject.repository.UserRepository;
import com.mini.miniproject.security.JwtTokenProvider;
import com.mini.miniproject.security.UserDetailsImpl;
import com.mini.miniproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/user/signup") // 회원가입.
    public String registerUser(@RequestBody UserDto requestDto) {
        userService.registerUser(requestDto);
        return "index.html";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/user/login")
    public List<Map<String,String>> login(@RequestBody Map<String, String> user) {
        System.out.println(user);
        User member = userRepository.findById(user.get("username"))
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 username 입니다."));
        System.out.println(member);
        System.out.println(user.get("username"));
        if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        Map<String,String>username =new HashMap<>();
        Map<String,String>token = new HashMap<>();
        List<Map<String,String>> tu = new ArrayList<>(); // -> 리스트를 만드는데, Map형태(키:밸류 형태)의 변수들을 담을 것이다.

        token.put("token",jwtTokenProvider.createToken(member.getUserNick(), member.getId())); // "username" : {username}
        username.put("username",member.getUserNick()); // "token" : {token}
        tu.add(username); //List형태 ["username" : {username}]
        tu.add(token); //List형태 ["token" : {token}]
        return tu; // List형태 ["username" : {username}, token" : {token}]"
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/checklogin")
    public Boolean getComment(@AuthenticationPrincipal UserDetailsImpl userDetails)
    {
        if (userDetails != null)
            return true;
        return false;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/loginfail") // login fail
    public Boolean loginfail()
    {
        return false;
    }
    @CrossOrigin(origins = "http://localhost:3000")
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
