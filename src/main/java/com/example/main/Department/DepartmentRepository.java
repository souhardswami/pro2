package com.example.main.Department;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // @Query("SELECT * FROM Department WHERE id = :id")
    // List<Department> check(Long id);
    
    @Transactional
    @Modifying
    @Query("UPDATE department SET fund = :fund WHERE id = :id")
    void detectAmountFromDepartment(Long id, Long fund);
}