package com.rakib.salarymanagement.util;

import com.rakib.salarymanagement.entity.BankAccount;
import com.rakib.salarymanagement.enums.BankAccountType;
import com.rakib.salarymanagement.repositories.BankAccountRepository;
import com.rakib.salarymanagement.service.BankAccountService;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class DbInit {
    private final BankAccountService bankAccountService;
    private final BankAccountRepository bankAccountRepository;

    public DbInit(BankAccountService bankAccountService, BankAccountRepository bankAccountRepository) {
        this.bankAccountService = bankAccountService;
        this.bankAccountRepository = bankAccountRepository;
    }

    @PostConstruct
    public void saveCompanyBankAccount() {
        BankAccount bankAccount = bankAccountService.getByAccountName(UtilConstant.companyBankAccountName);
        if (bankAccount == null) {
            BankAccount bc = new BankAccount();
            bc.setAccountName(UtilConstant.companyBankAccountName);
            bc.setAccountNumber("std1000123");
            bc.setAccountType(BankAccountType.SAVINGS);
            bc.setBankName("Standard Bank");
            bc.setBranchName("Farmgate");
            bankAccountRepository.save(bc);
        }
    }
}
