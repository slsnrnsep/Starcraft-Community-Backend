package com.mini.miniproject.repository;

import com.mini.miniproject.model.Comment;
import com.mini.miniproject.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllByPostidOrderByCreatedAtDesc(Long postId);
}
