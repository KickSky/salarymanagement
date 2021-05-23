package com.rakib.salarymanagement.service;

import com.rakib.salarymanagement.dto.BankAccountDto;
import com.rakib.salarymanagement.dto.Response;
import com.rakib.salarymanagement.entity.BankAccount;

public interface BankAccountService {
    Response save(BankAccountDto bankAccountDto);

    Response update(Long id, BankAccountDto bankAccountDto);

    Response getById(Long id);

    Response del(Long id);

    Response getAll();

    BankAccount getByAccountName(String accountName);
}
