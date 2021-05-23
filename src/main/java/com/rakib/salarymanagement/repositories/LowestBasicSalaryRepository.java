package com.rakib.salarymanagement.repositories;

import com.rakib.salarymanagement.entity.LowestBasicSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LowestBasicSalaryRepository extends JpaRepository<LowestBasicSalary, Long> {
    @Query("from LowestBasicSalary where activeStatus = (:activeStatus) ")
    List<LowestBasicSalary> list(@Param("activeStatus") Integer activeStatus);

    @Query("from LowestBasicSalary where id = :salaryId and activeStatus = :activeStatus")
    LowestBasicSalary getByIdAndActiveStatusTrue(@Param("salaryId") Long bankId, @Param("activeStatus") Integer activeStatus);

}
