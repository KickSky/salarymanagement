package com.rakib.salarymanagement.entity;

import com.rakib.salarymanagement.dto.BankAccountDto;
import com.rakib.salarymanagement.enums.EmployeeGrade;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Data
@Entity
public class Employee extends BaseEntity {
    private Long employeeID;
    private String employeeName;
    private EmployeeGrade employeeGrade;
    private String address;
    private String mobileNo;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private BankAccount bankAccount;
}
