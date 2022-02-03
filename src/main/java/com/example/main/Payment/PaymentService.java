package com.example.main.Payment;

import javax.transaction.Transactional;

import com.example.main.Department.Department;
import com.example.main.Department.DepartmentRepository;
import com.example.main.Employee.Employee;
import com.example.main.Employee.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {

    private final EmployeeRepository employeeRepository2; 
    private final DepartmentRepository departmentRepository2; 
    

    @Autowired
    public PaymentService(EmployeeRepository employeeRepository2, DepartmentRepository departmentRepository2) {
        this.employeeRepository2 = employeeRepository2;
        this.departmentRepository2 = departmentRepository2;
    }

    

    
    @Transactional
    public void makePayment(Payment payment){
        // Do something with payment.

        Employee employee = employeeRepository2.findPayment(payment.getEmployeeId()).get(0);
        employeeRepository2.addAmountInEmployeesAccount(payment.getEmployeeId(), payment.getAmount() + employee.getAmount());

        Department department = employee.getDepartment();
        departmentRepository2.detectAmountFromDepartment(department.getId(), department.getFund() - payment.getAmount());


    }

    
}


