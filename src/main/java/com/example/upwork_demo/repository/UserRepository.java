package com.example.upwork_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.upwork_demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
