package com.mini.miniproject.repository;

import com.mini.miniproject.model.Heart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HeartRepository extends JpaRepository<Heart, Long> {
    Optional<Heart> findByPostIdAndUserId(Long postId, String UserId);
}

