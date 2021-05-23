package com.rakib.salarymanagement.dto;

import lombok.Data;


@Data
public class EmployeeDto extends BaseDto {
    private Long employeeID;
    private String employeeName;
    private Integer employeeGrade;
    private String address;
    private String mobileNo;
    private BankAccountDto bankAccount;
}
