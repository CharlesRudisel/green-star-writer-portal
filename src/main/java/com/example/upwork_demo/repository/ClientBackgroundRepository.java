package com.example.upwork_demo.repository;

import com.example.upwork_demo.model.ClientBackground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientBackgroundRepository extends JpaRepository<ClientBackground, Long> {
}
