package com.example.main.Employee;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    



    @Query("SELECT n FROM Employee n WHERE n.id = ?1")
    List<Employee> findPayment(Long id);

    
    @Transactional
    @Modifying
    @Query("UPDATE Employee SET amount = :amount WHERE id = :id")
    void addAmountInEmployeesAccount(Long id, Long amount);



}
