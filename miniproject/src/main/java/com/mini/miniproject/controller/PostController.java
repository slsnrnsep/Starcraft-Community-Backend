package com.mini.miniproject.controller;

import com.mini.miniproject.model.FileDto;
import com.mini.miniproject.model.Post;
import com.mini.miniproject.dto.PostDto;
import com.mini.miniproject.repository.PostRepository;
import com.mini.miniproject.security.UserDetailsImpl;
import com.mini.miniproject.service.FileService;
import com.mini.miniproject.service.PostService;
import com.mini.miniproject.util.MD5Generator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;
    private final FileService fileService;
    private String commonPath = "\\src\\main\\resources\\static\\images";
    //게시글 작성
    @PostMapping("/api/post")
    public Post createPosts (
            @RequestParam("file") MultipartFile files,
            PostDto reqdto,
            @AuthenticationPrincipal UserDetailsImpl userDetails)
    {
        try {
            String filename = "basic.jpg";
            if(!files.getOriginalFilename().equals("")) {
                String origFilename = files.getOriginalFilename();
                filename = new MD5Generator(origFilename).toString() + ".jpg";
                /* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
                String savePath = System.getProperty("user.dir") + commonPath;
                /* 파일이 저장되는 폴더가 없으면 폴더를 생성합니다. */
                //files.part.getcontententtype() 해서 이미지가 아니면 false처리해야함.
                if (!new File(savePath).exists()) {
                    try {
                        new File(savePath).mkdir();
                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                }
                String filePath = savePath + "\\" + filename;
                files.transferTo(new File(filePath));
            }
//            FileDto fileDto = new FileDto();
//            fileDto.setOrigFilename(origFilename);
//            fileDto.setFilename(filename);
//            fileDto.setFilePath(filePath);
//            Long fileId = fileService.saveFile(fileDto);
            String username = "tmdwns123";
            reqdto.setFilePath("/images/"+filename);
            Post posts = postService.createPosts(reqdto,username);
            return null;
        }
        catch (Exception e) {
            return null;
        }
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
        List<Post> posts = postRepository.findAllByCategori(categori);
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
        //삭제할때 댓글들 자동으로삭제하는지 확인해야함..
        postRepository.deleteById(id);
        return id;
    }

}
