package com.rakib.salarymanagement.service.impl;

import com.rakib.salarymanagement.dto.BankAccountDto;
import com.rakib.salarymanagement.dto.Response;
import com.rakib.salarymanagement.entity.BankAccount;
import com.rakib.salarymanagement.enums.ActiveStatus;
import com.rakib.salarymanagement.repositories.BankAccountRepository;
import com.rakib.salarymanagement.service.BankAccountService;
import com.rakib.salarymanagement.util.ResponseBuilder;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        BankAccount bankAccount = bankAccountRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (bankAccount != null) {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            BankAccountDto bankAccountDto = modelMapper.map(bankAccount, BankAccountDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + " retrieved Successfully", bankAccountDto);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + " not found");
    }

    @Override
    public Response del(Long id) {
        return null;
    }

    @Override
    public Response getAll() {
        List<BankAccount> bankAccountList = bankAccountRepository.list(ActiveStatus.ACTIVE.getValue());
        if (bankAccountList.isEmpty() || bankAccountList == null)
            return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, "No Bank Account Is available");
        List<BankAccountDto> list = getBankAccount(bankAccountList);
        return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Data Retrieve Successfully", list);
    }

    private List<BankAccountDto> getBankAccount(List<BankAccount> bankAccounts) {
        List<BankAccountDto> bankAccountDtoList = new ArrayList<>();
        bankAccounts.forEach(bankAccount -> {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            BankAccountDto bankAccountDto = modelMapper.map(bankAccount, BankAccountDto.class);
            bankAccountDtoList.add(bankAccountDto);
        });
        return bankAccountDtoList;
    }
}
