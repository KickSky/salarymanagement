package com.rakib.salarymanagement.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@Entity
public class Journal extends BaseEntity {
    private String title;
    private Long fromAccount;
    private Long ToAccount;
    @OneToOne
    @JoinColumn(name = "employeeId")
    private Employee employeeId;
    private double amount;
}
