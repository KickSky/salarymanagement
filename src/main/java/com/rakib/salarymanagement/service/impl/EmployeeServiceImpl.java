package com.rakib.salarymanagement.service.impl;

import com.rakib.salarymanagement.dto.EmployeeDto;
import com.rakib.salarymanagement.dto.Response;
import com.rakib.salarymanagement.entity.Employee;
import com.rakib.salarymanagement.enums.ActiveStatus;
import com.rakib.salarymanagement.repositories.EmployeeRepository;
import com.rakib.salarymanagement.service.EmployeeService;
import com.rakib.salarymanagement.util.ResponseBuilder;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final String root = "Employee";

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Response save(EmployeeDto employeeDto) {
        Employee employee;
        employee = modelMapper.map(employeeDto, Employee.class);
        employee = employeeRepository.save(employee);
        if (employee != null) {
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, root + " Has been Created", null);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
    }

    @Override
    public Response update(Long id, EmployeeDto employeeDto) {
        Employee employee;
        employee = employeeRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (employee != null) {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            employee = modelMapper.map(employeeDto, Employee.class);
            employee = employeeRepository.save(employee);
            if (employee != null) {
                return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, root + " Has been Updated", null);
            }
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + " not found");
    }

    @Override
    public Response getById(Long id) {
        Employee employee = employeeRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (employee != null) {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + " retrieved Successfully", employeeDto);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + " not found");
    }

    @Override
    public Response del(Long id) {
        Employee employee = employeeRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (employee != null) {
            employee.setActiveStatus(ActiveStatus.DELETE.getValue());
            employeeRepository.save(employee);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + " Has been Deleted Successfully", "");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + " not found");
    }

    @Override
    public Response getAll() {
        List<Employee> employeeList = employeeRepository.list(ActiveStatus.ACTIVE.getValue());
        if (employeeList.isEmpty() || employeeList == null)
            return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, "No Basic Salary Is available");
        List<EmployeeDto> list = getEmployee(employeeList);
        return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Data Retrieve Successfully", list);
    }

    private List<EmployeeDto> getEmployee(List<Employee> employees) {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        employees.forEach(employee -> {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
            employeeDtoList.add(employeeDto);
        });
        return employeeDtoList;
    }
}
