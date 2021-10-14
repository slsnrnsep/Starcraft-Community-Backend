package com.mini.miniproject.controller;

import com.mini.miniproject.dto.HeartRequestDto;
import com.mini.miniproject.security.UserDetailsImpl;
import com.mini.miniproject.service.HeartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class HeartController {

    private final HeartService heartService;

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/api/post/{id}/like")
    public String likePost(@PathVariable Long id, @RequestBody HeartRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        //id postid
        //isliked 좋아요상태
        boolean liked = heartService.liked(id, requestDto, userDetails);
        if(liked){
            return "true";
        }
        else{
            return "false";
        }
    }
}