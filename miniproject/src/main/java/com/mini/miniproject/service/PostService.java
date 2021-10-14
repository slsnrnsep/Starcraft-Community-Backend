package com.mini.miniproject.service;

import com.mini.miniproject.model.Post;
import com.mini.miniproject.dto.PostDto;
import com.mini.miniproject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    //게시글 작성시 xss공격 확인 후 리턴
    @Transactional
    public Post createPosts(PostDto requestDto, String username) {
        String contentsCheck = requestDto.getContent();
        String titleCheck = requestDto.getTitle();

        if (contentsCheck.contains("script")||contentsCheck.contains("<")||contentsCheck.contains(">")){
            Post post = new Post(requestDto,username,"xss no");
            postRepository.save(post);
            return post;
        }

        if (titleCheck.contains("script")||titleCheck.contains("<")||titleCheck.contains(">")) {
            Post post= new Post("xss no", username, "xss 안돼요,,하지마세요ㅠㅠ");
            postRepository.save(post);
            return post;
        }

        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Post post = new Post(requestDto, username);
        postRepository.save(post);
        return post;
    }

    //게시글 업데이트
    @Transactional
    public Long update(Long id, PostDto reqDto) {
        Post post = postRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        post.update(reqDto);
        postRepository.save(post);
        return post.getId();
    }
}
