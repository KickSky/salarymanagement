package com.rakib.salarymanagement.entity;

import com.rakib.salarymanagement.dto.BankAccountDto;
import com.rakib.salarymanagement.enums.EmployeeGrade;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Employee extends BaseEntity {
    private Long employeeID;
    private String employeeName;
    private EmployeeGrade employeeGrade;
    private String address;
    private String mobileNo;
    private BankAccount bankAccount;
}
