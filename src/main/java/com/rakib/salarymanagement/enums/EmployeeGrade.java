package com.rakib.salarymanagement.enums;

public enum EmployeeGrade {
    GradeOne(1),
    GradeTwo(2),
    GradeThree(3),
    GradeFour(4),
    GradeFive(5),
    GradeSix(6);

    private final int value;

    EmployeeGrade(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
