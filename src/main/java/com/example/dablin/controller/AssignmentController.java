package com.example.dablin.controller;

import com.example.dablin.DTO.AssignmentResponseDTO;
import com.example.dablin.domain.Assignment;
import com.example.dablin.domain.User;
import com.example.dablin.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    @Autowired
    AssignmentService assignmentService;

    @PostMapping("")
    public ResponseEntity<?> createAssignment(@AuthenticationPrincipal User user) {
        Assignment newAssignment = assignmentService.save(user);

        return ResponseEntity.ok(newAssignment);
    }

    @GetMapping("")
    public ResponseEntity<?> getAssignments(@AuthenticationPrincipal User user) {
        
        Set<Assignment> assignmentByUser = assignmentService.findByUser(user);
        return ResponseEntity.ok(assignmentByUser);
    }

    @GetMapping("{assignmentId}")
    public ResponseEntity<?> getAssignment(@AuthenticationPrincipal User user,
                                           @PathVariable Long assignmentId) {
        Optional<Assignment> assignmentOpt = assignmentService.findById(assignmentId);

        AssignmentResponseDTO response = new
                AssignmentResponseDTO(assignmentOpt.orElse(
                new Assignment()));
        return ResponseEntity.ok(response);
    }

    @PutMapping("{assignmentId}")
    public ResponseEntity<?> updateAssignment(@AuthenticationPrincipal User user,
                                              @RequestBody Assignment assignment,
                                              @PathVariable Long assignmentId) {
        Assignment updatedAssignment = assignmentService.save(assignment);
        return ResponseEntity.ok(updatedAssignment);
    }

}
