package com.rakib.salarymanagement.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class LowestBasicSalary extends BaseEntity {
    private Double lowestBasicSalary;
}
