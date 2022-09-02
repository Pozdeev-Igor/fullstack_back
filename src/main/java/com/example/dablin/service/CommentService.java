package com.example.dablin.service;

import com.example.dablin.DTO.CommentDTO;
import com.example.dablin.domain.Assignment;
import com.example.dablin.domain.Comment;
import com.example.dablin.domain.User;
import com.example.dablin.repos.AssignmentRepo;
import com.example.dablin.repos.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Set;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private AssignmentRepo assignmentRepo;

    public Comment save(CommentDTO commentDTO, User user) {

        Comment comment = new Comment();
        Assignment assignment = assignmentRepo.getById(commentDTO.getAssignmentId());

        comment.setId(commentDTO.getId());
        comment.setText(commentDTO.getText());
        comment.setCreatedBy(user);
        comment.setAssignment(assignment);
        if (comment.getId() == null)
            comment.setCreatedDate(ZonedDateTime.now());
        else
            comment.setCreatedDate(commentDTO.getCreatedDate());

        return commentRepo.save(comment);
    }

    public Set<Comment> getCommentsByAssignmentId(Long assignmentId) {
        Set<Comment> comments = commentRepo.findByAssignmentId(assignmentId);

        return comments;
    }

    public void delete(Long commentId) {
        commentRepo.deleteById(commentId);
    }
}
