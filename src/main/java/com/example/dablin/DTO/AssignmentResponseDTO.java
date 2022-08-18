package com.example.dablin.DTO;

import com.example.dablin.Enums.AssignmentEnum;
import com.example.dablin.Enums.AssignmentStatusEnum;
import com.example.dablin.domain.Assignment;

public class AssignmentResponseDTO {

    private Assignment assignment;
    private AssignmentEnum[] assignmentEnums = AssignmentEnum.values();
    private AssignmentStatusEnum[] statusEnum = AssignmentStatusEnum.values();

    public AssignmentResponseDTO(Assignment assignment) {
        super();
        this.assignment = assignment;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public AssignmentEnum[] getAssignmentEnums() {
        return assignmentEnums;
    }

    public AssignmentStatusEnum[] getStatusEnum() {
        return statusEnum;
    }
}
