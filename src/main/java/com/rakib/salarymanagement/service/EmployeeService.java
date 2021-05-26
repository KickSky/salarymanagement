package com.rakib.salarymanagement.service;

import com.rakib.salarymanagement.dto.EmployeeDto;
import com.rakib.salarymanagement.dto.Response;

public interface EmployeeService {
    Response save(EmployeeDto employeeDto);

    Response update(Long id, EmployeeDto employeeDto);

    Response getById(Long id);

    Response del(Long id);

    Response getAll();
}
