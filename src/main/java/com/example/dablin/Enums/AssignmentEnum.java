package com.example.dablin.Enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AssignmentEnum {
    ASSIGNMENT_1(1, "HTML assignment"),
    ASSIGNMENT_2(2, "Guessing game"),
    ASSIGNMENT_3(3, "User Login"),
    ASSIGNMENT_4(4, "Student course list"),
    ASSIGNMENT_5(5, "Custom array list"),
    ASSIGNMENT_6(6, "Reports with streams"),
    ASSIGNMENT_7(7, "Unit testing"),
    ASSIGNMENT_8(8, "Multi-threading"),
    ASSIGNMENT_9(9, "Spring MVC"),
    ASSIGNMENT_10(10, "RESTful service"),
    ASSIGNMENT_11(11, "Full-stack with thymeleaf"),
    ASSIGNMENT_12(12, "Reports with SQL"),
    ASSIGNMENT_13(13, "Online bank"),
    ASSIGNMENT_14(14, "Chatting with JS");

    private int assignmentNum;
    private String assignmentName;

    AssignmentEnum(int assignmentNum, String assignmentName) {
        this.assignmentNum = assignmentNum;
        this.assignmentName = assignmentName;
    }

    public int getAssignmentNum() {
        return assignmentNum;
    }

    public String getAssignmentName() {
        return assignmentName;
    }
}
