package com.example.dablin.DTO;

import com.example.dablin.domain.User;

public class CommentDTO {
    private Long assignmentId;
    private String text;
    private String user;

    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "assignmentId=" + assignmentId +
                ", text='" + text + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
