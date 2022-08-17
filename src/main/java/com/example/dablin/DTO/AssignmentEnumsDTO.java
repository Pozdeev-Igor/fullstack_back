package com.example.dablin.DTO;

public class AssignmentEnumsDTO {
    private String assignmentName;
    private Integer assignmentNum;

    public AssignmentEnumsDTO(String assignmentName, Integer assignmentNum) {
        super();
        this.assignmentName = assignmentName;
        this.assignmentNum = assignmentNum;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public Integer getAssignmentNum() {
        return assignmentNum;
    }

    public void setAssignmentNum(Integer assignmentNum) {
        this.assignmentNum = assignmentNum;
    }
}
