package com.example.dablin.repos;

import com.example.dablin.domain.Assignment;
import com.example.dablin.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AssignmentRepo extends JpaRepository<Assignment, Long> {

     Set<Assignment> findByUser (User user);

}
