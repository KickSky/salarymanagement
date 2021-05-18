package com.rakib.salarymanagement.dto;

import lombok.Data;

import javax.persistence.OneToOne;

@Data
public class EmployeeDto extends BaseDto {
    private Long employeeID;
    private String employeeName;
    private Integer employeeGrade;
    private String address;
    private String mobileNo;
    @OneToOne
    private BankAccountDto bankAccount;
}
