package com.example.upwork_demo.controller;

import com.example.upwork_demo.model.Grade;
import com.example.upwork_demo.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable Long id) {
        Optional<Grade> grade = gradeService.getGradeById(id);
        return grade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Grade createGrade(@RequestBody Grade grade) {
        return gradeService.saveGrade(grade);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<Grade>> createGrades(@RequestBody List<Grade> grades) {
        List<Grade> createdGrades = gradeService.saveAllGrades(grades);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGrades);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grade> updateGrade(@PathVariable Long id, @RequestBody Grade gradeDetails) {
        Optional<Grade> gradeOptional = gradeService.getGradeById(id);

        if (!gradeOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Grade grade = gradeOptional.get();
        grade.setFeedback(gradeDetails.getFeedback());
        grade.setGrade(gradeDetails.getGrade());
        Grade updatedGrade = gradeService.saveGrade(grade);
        return ResponseEntity.ok(updatedGrade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Long id) {
        if (!gradeService.getGradeById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        gradeService.deleteGrade(id);
        return ResponseEntity.noContent().build();
    }
}
