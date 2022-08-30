package com.example.dablin.repos;

import com.example.dablin.Enums.AssignmentStatusEnum;
import com.example.dablin.domain.Assignment;
import com.example.dablin.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface AssignmentRepo extends JpaRepository<Assignment, Long> {

     Set<Assignment> findByUser (User user);

    @Query("select a from Assignment a where a.status = 'Submitted'")
    Set<Assignment> findByCodeReviewer(User user);
}
