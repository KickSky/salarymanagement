package com.rakib.salarymanagement.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class BankAccount extends BaseEntity {
    private String accountName;
    private Long accountNumber;
    private String accountType;
    private double currentBalance;
    private String bankName;
    private String branchName;
}
