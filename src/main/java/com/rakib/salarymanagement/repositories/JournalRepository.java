package com.rakib.salarymanagement.repositories;

import com.rakib.salarymanagement.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {

    @Query("from Journal where activeStatus = (:activeStatus) ")
    List<Journal> list(@Param("activeStatus") Integer activeStatus);

    @Query("from BankAccount where id = :journalId and activeStatus = :activeStatus")
    Journal getByIdAndActiveStatusTrue(@Param("journalId") Long journalId, @Param("activeStatus") Integer activeStatus);

}
