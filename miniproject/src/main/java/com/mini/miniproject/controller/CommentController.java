package com.mini.miniproject.controller;

import com.mini.miniproject.model.Comment;
import com.mini.miniproject.dto.CommentDto;
import com.mini.miniproject.repository.CommentRepository;
import com.mini.miniproject.security.UserDetailsImpl;
import com.mini.miniproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Controller
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    //    //로그인 유저 댓글 조회
//    @GetMapping("/api/comment")
//    public List<Comment> getComment(@AuthenticationPrincipal UserDetailsImpl userDetails)
//    {
//        Long userId = userDetails.getUser().getId();
//        return CommentService.getComment(userId);
//    }
    //댓글 작성
//    @PostMapping("/api/comment")
//    public void createReply(@RequestBody CommentDto reqDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
//        // 로그인 되어 있는 ID
////        if (userDetails != null) { // LSJ Test하려고 잠깐 주석처리
////        String userId = userDetails.getUser().getId();
//        String userId = "tmdwns123";
//        reqDto.setUserNick(userId);
//        commentService.createComment(reqDto);
//            //null나오면 false되도록
////            if(commentService.createComment(reqDto))
//
////        }
//    }

    @CrossOrigin(origins = "http://localhost:9999")
    @PostMapping("/api/comment")
    public void addcomment(
            @RequestBody CommentDto requestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails)
    {
        //if (userDetails != null) 이구문 차후에 추가해줘야함
        requestDto.setUserNick("tmdwns123");
        commentService.createComment(requestDto);
    }


    //댓글 조회
    @CrossOrigin(origins = "http://localhost:9999")
    @GetMapping("/api/comment/{id}")
    public List<Comment> getComment(@PathVariable Long postId)
    {
        return commentService.getComment(postId);
    }

    //댓글 수정
    @CrossOrigin(origins = "http://localhost:9999")
    @PutMapping("/api/comment/{id}")
    public Long updateReply(@PathVariable Long id, @RequestBody CommentDto reqDto) {
        commentService.update(id, reqDto);
        return id;
    }

    //댓글 삭제
    @CrossOrigin(origins = "http://localhost:9999")
    @DeleteMapping("/api/comment/{id}")
    public Long deleteReply(@PathVariable Long id) {
        commentService.delete(id);
        return id;
    }


}
