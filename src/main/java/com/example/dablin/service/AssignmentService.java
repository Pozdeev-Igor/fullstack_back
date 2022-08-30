package com.example.dablin.service;

import com.example.dablin.Enums.AssignmentStatusEnum;
import com.example.dablin.Enums.AuthorityEnum;
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
        assignment.setStatus(AssignmentStatusEnum.PENDING_SUBMISSION.getStatus());
        assignment.setNumber(findNextAssignmentToSubmit(user));
        assignment.setUser(user);
        return assignmentRepo.save(assignment);
    }

    private Integer findNextAssignmentToSubmit(User user) {
        Set<Assignment> assignmentsByUser = assignmentRepo.findByUser(user);

        if (assignmentsByUser == null) {
            return 1;
        }
        Optional<Integer> nextAssignmentNumberOpt = assignmentsByUser.stream()
                .sorted((a1, a2) -> {
                    if (a1.getNumber() == null) {
                        return 1;
                    }
                    if (a2.getNumber() == null) {
                        return 1;
                    }
                    return a2.getNumber().compareTo(a1.getNumber());
                })
                .map(assignment -> {
                    if (assignment.getNumber() == null) return 1;

                    return assignment.getNumber() + 1;
                })
                .findFirst();
        return nextAssignmentNumberOpt.orElse(1);
    }

    public Set<Assignment> findByUser(User user) {

        boolean hasCodeReviewerRole = user.getAuthorities()
                .stream()
                .filter(auth -> AuthorityEnum.ROLE_CODE_REVIEWER.name().equals(auth.getAuthority()))
                .count() > 0;
        if (hasCodeReviewerRole) {
            // load assignments if you're a code reviewer role
            return assignmentRepo.findByCodeReviewer(user);
        } else {
            // load assignments if you're a student role
            return assignmentRepo.findByUser(user);
        }
    }

    public Optional<Assignment> findById(Long assignmentId) {
        return assignmentRepo.findById(assignmentId);
    }

    public Assignment save(Assignment assignment) {
        return assignmentRepo.save(assignment);

    }
}
