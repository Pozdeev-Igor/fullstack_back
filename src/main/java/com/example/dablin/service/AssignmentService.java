package com.example.dablin.service;

import com.example.dablin.domain.Assignment;
import com.example.dablin.domain.User;
import com.example.dablin.repos.AssignmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class AssignmentService {
    @Autowired
    AssignmentRepo assignmentRepo;
    public Assignment save(User user) {
        Assignment assignment = new Assignment();
        assignment.setStatus("Needs to be submitted");
        assignment.setUser(user);
        return assignmentRepo.save(assignment);
    }

    public Set<Assignment> findByUser (User user) {
        return  assignmentRepo.findByUser(user);
    }

    public Optional<Assignment> findById(Long assignmentId) {
        return assignmentRepo.findById(assignmentId);
    }

    public Assignment save(Assignment assignment) {
        return assignmentRepo.save(assignment);

    }
}
