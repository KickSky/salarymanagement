package com.rakib.salarymanagement.service.impl;

import com.rakib.salarymanagement.dto.LowestBasicSalaryDto;
import com.rakib.salarymanagement.dto.Response;
import com.rakib.salarymanagement.entity.LowestBasicSalary;
import com.rakib.salarymanagement.enums.ActiveStatus;
import com.rakib.salarymanagement.repositories.LowestBasicSalaryRepository;
import com.rakib.salarymanagement.service.LowestBasicSalaryService;
import com.rakib.salarymanagement.util.ResponseBuilder;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LowestBasicSalaryServiceImpl implements LowestBasicSalaryService {
    private final LowestBasicSalaryRepository lowestbasicSalaryRepository;
    private final ModelMapper modelMapper;
    private final String root = "Lowest Basic Salary";

    public LowestBasicSalaryServiceImpl(LowestBasicSalaryRepository lowestbasicSalaryRepository, ModelMapper modelMapper) {
        this.lowestbasicSalaryRepository = lowestbasicSalaryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Response save(LowestBasicSalaryDto lowestBasicSalaryDto) {
        LowestBasicSalary lowestBasicSalary;
        lowestBasicSalary = modelMapper.map(lowestBasicSalaryDto, LowestBasicSalary.class);
        lowestBasicSalary = lowestbasicSalaryRepository.save(lowestBasicSalary);
        if (lowestBasicSalary != null) {
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, root + " Has been Created", null);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
    }

    @Override
    public Response update(Long id, LowestBasicSalaryDto lowestBasicSalaryDto) {
        LowestBasicSalary lowestBasicSalary;
        lowestBasicSalary = lowestbasicSalaryRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (lowestBasicSalary != null) {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            lowestBasicSalary = modelMapper.map(lowestBasicSalaryDto, LowestBasicSalary.class);
            lowestBasicSalary = lowestbasicSalaryRepository.save(lowestBasicSalary);
            if (lowestBasicSalary != null) {
                return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, root + " Has been Updated", null);
            }
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + " not found");
    }

    @Override
    public Response getById(Long id) {
        LowestBasicSalary lowestBasicSalary = lowestbasicSalaryRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (lowestBasicSalary != null) {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            LowestBasicSalaryDto lowestBasicSalaryDto = modelMapper.map(lowestBasicSalary, LowestBasicSalaryDto.class);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + " retrieved Successfully", lowestBasicSalaryDto);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + " not found");
    }

    @Override
    public Response del(Long id) {
        LowestBasicSalary lowestBasicSalary = lowestbasicSalaryRepository.getByIdAndActiveStatusTrue(id, ActiveStatus.ACTIVE.getValue());
        if (lowestBasicSalary != null) {
            lowestBasicSalary.setActiveStatus(ActiveStatus.DELETE.getValue());
            lowestbasicSalaryRepository.save(lowestBasicSalary);
            return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + " Has been Deleted Successfully", "");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, root + " not found");
    }

    @Override
    public Response getAll() {
        List<LowestBasicSalary> lowestBasicSalaryList = lowestbasicSalaryRepository.list(ActiveStatus.ACTIVE.getValue());
        if (lowestBasicSalaryList.isEmpty() || lowestBasicSalaryList == null)
            return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND, "No Basic Salary Is available");
        List<LowestBasicSalaryDto> list = getLowestBasicSalary(lowestBasicSalaryList);
        return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Data Retrieve Successfully", list);
    }

    private List<LowestBasicSalaryDto> getLowestBasicSalary(List<LowestBasicSalary> lowestBasicSalaries) {
        List<LowestBasicSalaryDto> lowestSalaryDtoList = new ArrayList<>();
        lowestBasicSalaries.forEach(lowestBasicSalary -> {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            LowestBasicSalaryDto lowestBasicSalaryDto = modelMapper.map(lowestBasicSalary, LowestBasicSalaryDto.class);
            lowestSalaryDtoList.add(lowestBasicSalaryDto);
        });
        return lowestSalaryDtoList;
    }
}
