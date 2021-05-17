package com.rakib.salarymanagement.controller;

import com.rakib.salarymanagement.annotations.ApiController;
import com.rakib.salarymanagement.dto.BankAccountDto;
import com.rakib.salarymanagement.dto.Response;
import com.rakib.salarymanagement.service.BankAccountService;
import com.rakib.salarymanagement.util.UrlConstraint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
