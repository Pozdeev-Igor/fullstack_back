package com.example.dablin.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cmmnts")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    private Assignment assignment;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdBy;
    private LocalDateTime createdDate;
    @Column(length = 5000)
    private String text;


    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
