package com.rakib.salarymanagement.dto;

import lombok.Data;


@Data
public class JournalDto extends BaseDto {
    private String title;
    private Long fromAccount;
    private Long ToAccount;
    private EmployeeDto employeeId;
    private double amount;
}
