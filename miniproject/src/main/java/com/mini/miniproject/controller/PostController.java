package com.mini.miniproject.controller;

import com.mini.miniproject.model.Post;
import com.mini.miniproject.model.PostDto;
import com.mini.miniproject.repository.PostRepository;
import com.mini.miniproject.security.UserDetailsImpl;
import com.mini.miniproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    //게시글 작성
    @PostMapping("/api/post")
    public Post createPosts(@RequestBody PostDto reqdto, @AuthenticationPrincipal UserDetailsImpl userDetails)
    {
        String username = userDetails.getUser().getUserNick();
        Post posts = postService.createPosts(reqdto,username);
        return posts;
    }

    //게시글 전체 조회
    @GetMapping("/api/post")
    public List<Post> getPosts()
    {
      return postRepository.findAllByOrderByCreatedAtDesc();
    }

    //게시글 상세 조회
    @GetMapping("/api/post/{id}")
    public Post getPosts(@PathVariable Long id){
        Post post = postRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("ID가 존재하지 않습니다."));

        return post;
    }

    //게시글 카테고리별 조회
    @GetMapping("/api/post/categori/{categori}")
    public List<Post> getCategoriPosts(@PathVariable Long categori)
    {
        List<Post> posts = postRepository.findAllById(categori);
        return posts;
    }

    //게시글 수정
    @PutMapping("/api/post/{id}")
    public Long updatePosts(@PathVariable Long id,@RequestBody PostDto reqDto)
    {
        postService.update(id,reqDto);
        return id;
    }

    //게시글 삭제
    @DeleteMapping("/api/post/{id}")
    public Long deletePosts(@PathVariable Long id)
    {
        postRepository.deleteById(id);
        return id;
    }

}
