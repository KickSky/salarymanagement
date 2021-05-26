package com.rakib.salarymanagement.entity;

import com.rakib.salarymanagement.enums.BankAccountType;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class BankAccount extends BaseEntity {
    private String accountName;
    private String accountNumber;
    private BankAccountType accountType;
    private double currentBalance;
    private String bankName;
    private String branchName;
}
