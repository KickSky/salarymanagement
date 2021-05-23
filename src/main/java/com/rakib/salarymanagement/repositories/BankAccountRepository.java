package com.rakib.salarymanagement.repositories;

import com.rakib.salarymanagement.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    @Query("from BankAccount where activeStatus = (:activeStatus) ")
    List<BankAccount> list(@Param("activeStatus") Integer activeStatus);

    @Query("from BankAccount where id = :bankId and activeStatus = :activeStatus")
    BankAccount getByIdAndActiveStatusTrue(@Param("bankId") Long bankId, @Param("activeStatus") Integer activeStatus);

    BankAccount getByAccountName(String accountName);
}
