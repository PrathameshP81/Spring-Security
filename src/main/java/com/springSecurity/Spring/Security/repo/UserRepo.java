package com.springSecurity.Spring.Security.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springSecurity.Spring.Security.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}