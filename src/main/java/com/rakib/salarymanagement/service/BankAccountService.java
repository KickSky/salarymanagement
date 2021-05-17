package com.rakib.salarymanagement.service;

import com.rakib.salarymanagement.dto.BankAccountDto;
import com.rakib.salarymanagement.dto.Response;

public interface BankAccountService {
    public Response save(BankAccountDto bankAccountDto);

    public Response update(Long id, BankAccountDto bankAccountDto);

    public Response getById(Long id);

    public Response del(Long id);

    public Response getAll();
}
