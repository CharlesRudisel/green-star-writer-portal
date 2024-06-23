package com.example.upwork_demo.service;

import com.example.upwork_demo.model.Grade;
import com.example.upwork_demo.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Optional<Grade> getGradeById(Long id) {
        return gradeRepository.findById(id);
    }

    public Grade saveGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public List<Grade> saveAllGrades(List<Grade> grades) {
        return gradeRepository.saveAll(grades);
    }

    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }
}
