package com.rakib.salarymanagement.service.impl;

import com.rakib.salarymanagement.dto.BankAccountDto;
import com.rakib.salarymanagement.dto.Response;
import com.rakib.salarymanagement.entity.BankAccount;
import com.rakib.salarymanagement.repositories.BankAccountRepository;
import com.rakib.salarymanagement.service.BankAccountService;
import com.rakib.salarymanagement.util.ResponseBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final ModelMapper modelMapper;
    private final String root = "Bank Account";

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository, ModelMapper modelMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Response save(BankAccountDto bankAccountDto) {
        BankAccount bankAccount;
        bankAccount = modelMapper.map(bankAccountDto, BankAccount.class);
        bankAccount = bankAccountRepository.save(bankAccount);
        if (bankAccount != null) {
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, root + " Has been Created", null);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
    }

    @Override
    public Response update(Long id, BankAccountDto bankAccountDto) {
        return null;
    }

    @Override
    public Response getById(Long id) {
        return null;
    }

    @Override
    public Response del(Long id) {
        return null;
    }

    @Override
    public Response getAll() {
        return null;
    }
}
