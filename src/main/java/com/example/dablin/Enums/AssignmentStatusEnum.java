package com.example.dablin.Enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AssignmentStatusEnum {
    PENDING_SUBMISSION("Pending submission", 1),
    SUBMITTED("Submitted", 2),
    IN_REVIEW("In review", 3),
    NEEDS_UPDATE("Needs update", 4),
    COMPLETED("Completed", 5),
    RESUBMITTED("Resubmitted", 6);

    private String status;
    private int orderStep;

    AssignmentStatusEnum(String status, Integer orderStep) {
        this.status = status;
        this.orderStep = orderStep;
    }

    public String getStatus() {
        return status;
    }

    public int getOrderStep() {
        return orderStep;
    }
}
