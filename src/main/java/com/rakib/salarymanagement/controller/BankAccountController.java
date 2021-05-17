package com.rakib.salarymanagement.controller;

import com.rakib.salarymanagement.annotations.ApiController;
import com.rakib.salarymanagement.dto.BankAccountDto;
import com.rakib.salarymanagement.dto.Response;
import com.rakib.salarymanagement.service.BankAccountService;
import com.rakib.salarymanagement.util.UrlConstraint;
import org.springframework.web.bind.annotation.*;

@ApiController
@RequestMapping(UrlConstraint.BankManagement.ROOT)
public class BankAccountController {

    private final BankAccountService bankAccountService;

    BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping
    public Response saveBankAccount(@RequestBody BankAccountDto bankAccountDto) {
        return bankAccountService.save(bankAccountDto);
    }

    @GetMapping
    public Response getBankList() {
        return bankAccountService.getAll();
    }

    @GetMapping(value = UrlConstraint.BankManagement.GET)
    public Response getBankAccountById(@PathVariable("bankId") Long bankId) {
        return bankAccountService.getById(bankId);
    }
}
