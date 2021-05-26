package com.rakib.salarymanagement.controller;

import com.rakib.salarymanagement.annotations.ApiController;
import com.rakib.salarymanagement.dto.LowestBasicSalaryDto;
import com.rakib.salarymanagement.dto.Response;
import com.rakib.salarymanagement.service.LowestBasicSalaryService;
import com.rakib.salarymanagement.util.UrlConstraint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@ApiController
@RequestMapping(UrlConstraint.LowestSalaryManagement.ROOT)
public class SalaryController {

    private final LowestBasicSalaryService lowestBasicSalaryService;

    public SalaryController(LowestBasicSalaryService lowestBasicSalaryService) {
        this.lowestBasicSalaryService = lowestBasicSalaryService;
    }

    @PostMapping
    public Response saveLowestSalary(@RequestBody LowestBasicSalaryDto lowestBasicSalaryDto) {
        return lowestBasicSalaryService.save(lowestBasicSalaryDto);
    }

    @GetMapping
    public Response getLowestSalaryList() {
        return lowestBasicSalaryService.getAll();
    }
}
