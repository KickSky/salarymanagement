package com.rakib.salarymanagement.repositories;

import com.rakib.salarymanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("from Employee where activeStatus = (:activeStatus) ")
    List<Employee> list(@Param("activeStatus") Integer activeStatus);

    @Query("from Employee where id = :employeeId and activeStatus = :activeStatus")
    Employee getByIdAndActiveStatusTrue(@Param("employeeId") Long bankId, @Param("activeStatus") Integer activeStatus);

}
