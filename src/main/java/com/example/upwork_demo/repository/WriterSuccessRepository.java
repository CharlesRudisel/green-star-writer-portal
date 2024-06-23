package com.example.upwork_demo.repository;

import com.example.upwork_demo.model.WriterSuccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WriterSuccessRepository extends JpaRepository<WriterSuccess, Long> {
}
