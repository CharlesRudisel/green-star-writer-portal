package com.example.upwork_demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "blog_topic")
    private String blogTopic;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "status")
    private String status; // Available, Claimed, Pending, Completed

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "assignment", cascade = CascadeType.ALL)
    private Grade grade;

    // Getters and Setters

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getBlogTopic() {
        return blogTopic;
    }

    public void setBlogTopic(String blogTopic) {
        this.blogTopic = blogTopic;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
        grade.setAssignment(this); // Ensures bidirectional consistency
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
