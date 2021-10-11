package com.mini.miniproject.service;

import com.mini.miniproject.model.Comment;
import com.mini.miniproject.model.CommentDto;
import com.mini.miniproject.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    //댓글 조회
    public List<Comment> getComment(Long postId) {
//        return commentRepository.findAllByPostidOrderByCreatedAtDesc(postId);
        return null;
    }

    //댓글 작성 서비스
    @Transactional
    public Comment createComment(CommentDto reqDto) {
        String CommentCheck = reqDto.getContent();
        if(CommentCheck.contains("script")||CommentCheck.contains("<")||CommentCheck.contains(">"))
        {
//            Comment comment = new Comment(reqDto, userId,"xss 안돼요,, 하지마세요ㅠㅠ");
//            commentRepository.save(comment);
            return null;
        }

        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Comment comment = new Comment(reqDto);
        commentRepository.save(comment);
        return comment;

    }


    //댓글 수정 서비스
    @Transactional
    public void update(Long id, CommentDto reqDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("존재하지 않습니다.")
        );
        comment.update(reqDto);
    }
}
