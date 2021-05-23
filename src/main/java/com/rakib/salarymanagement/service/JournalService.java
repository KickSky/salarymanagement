package com.rakib.salarymanagement.service;

import com.rakib.salarymanagement.dto.JournalDto;
import com.rakib.salarymanagement.dto.Response;

public interface JournalService {
    public Response save(JournalDto journalDto);

    public Response update(Long id, JournalDto journalDto);

    public Response getById(Long id);

    public Response del(Long id);

    public Response getAll();
}
