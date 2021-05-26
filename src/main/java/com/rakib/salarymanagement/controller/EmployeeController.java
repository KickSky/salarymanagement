package com.rakib.salarymanagement.controller;

import com.rakib.salarymanagement.annotations.ApiController;
import com.rakib.salarymanagement.dto.EmployeeDto;
import com.rakib.salarymanagement.dto.Response;
import com.rakib.salarymanagement.service.EmployeeService;
import com.rakib.salarymanagement.util.UrlConstraint;
import org.springframework.web.bind.annotation.*;

@ApiController
@RequestMapping(UrlConstraint.EmployeeManagement.ROOT)
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Response save(@RequestBody EmployeeDto employeeDto) {
        return employeeService.save(employeeDto);
    }

    @GetMapping
    public Response getEmployeeList() {
        return employeeService.getAll();
    }

    @GetMapping(value = UrlConstraint.EmployeeManagement.GET)
    public Response getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        return employeeService.getById(employeeId);
    }

    @DeleteMapping(value = UrlConstraint.EmployeeManagement.DELETE)
    public Response del(@PathVariable("employeeId") Long employeeId) {
        return employeeService.del(employeeId);
    }

    @PutMapping(value = UrlConstraint.EmployeeManagement.PUT)
    public Response update(@RequestBody EmployeeDto employeeDto, @PathVariable("employeeId") Long employeeId) {
        return employeeService.update(employeeId, employeeDto);
    }
}
