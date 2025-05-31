package com.gs.gs_java.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gs.gs_java.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String username);
}