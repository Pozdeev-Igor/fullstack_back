package com.example.dablin.repos;

import com.example.dablin.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface CommentRepo extends JpaRepository<Comment, Long> {
    @Query("select c from Comment c "
            + " where c.assignment.id = :assignmentId")
    Set<Comment> findByAssignmentId(Long assignmentId);
}
