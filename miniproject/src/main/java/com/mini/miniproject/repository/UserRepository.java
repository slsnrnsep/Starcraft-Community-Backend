package com.mini.miniproject.repository;

import com.mini.miniproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, String> {
}
