package com.mini.miniproject.repository;

import com.mini.miniproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, String> {
    Optional<User> findByUserNick(String username);
    Optional<User> findById(String email);
}
