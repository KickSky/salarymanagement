package com.rakib.salarymanagement.service;

import com.rakib.salarymanagement.dto.BankAccountDto;
import com.rakib.salarymanagement.dto.LowestBasicSalaryDto;
import com.rakib.salarymanagement.dto.Response;

public interface LowestBasicSalaryService {

    Response save(LowestBasicSalaryDto lowestBasicSalaryDto);

    Response update(Long id, LowestBasicSalaryDto lowestBasicSalaryDto);

    Response getById(Long id);

    Response del(Long id);

    Response getAll();
}
