package com.rakib.salarymanagement.service.impl;

import com.rakib.salarymanagement.dto.JournalDto;
import com.rakib.salarymanagement.dto.Response;
import com.rakib.salarymanagement.entity.Journal;
import com.rakib.salarymanagement.repositories.JournalRepository;
import com.rakib.salarymanagement.service.JournalService;
import com.rakib.salarymanagement.util.ResponseBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class JournalServiceImpl implements JournalService {

    private final JournalRepository journalRepository;
    private final ModelMapper modelMapper;
    private final String root = "Journal";

    public JournalServiceImpl(JournalRepository journalRepository, ModelMapper modelMapper) {
        this.journalRepository = journalRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public Response save(JournalDto journalDto) {
        Journal journal;
        journal = modelMapper.map(journalDto, Journal.class);
        journal = journalRepository.save(journal);
        if (journal != null) {
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, root + " Has been Created", null);
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
    }

    @Override
    public Response update(Long id, JournalDto journalDto) {
        return null;
    }

    @Override
    public Response getById(Long id) {
        return null;
    }

    @Override
    public Response del(Long id) {
        return null;
    }

    @Override
    public Response getAll() {
        return null;
    }
}
