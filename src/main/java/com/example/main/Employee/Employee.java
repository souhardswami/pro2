package com.example.main.Employee;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.main.Department.Department;

@Entity
@Table
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_seq",
            sequenceName = "employee_seq",
            allocationSize = 1                                            
    )

    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "employee_seq"
    )

    private Long id;
    private String name;
    private int age;
    private String email;
    private Long amount;

    @ManyToOne
    // @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private Department department;
    

    public Employee() {


    }

    public Employee(Long id, String name, int age, String email, Long amount ) {
        this.id = id;
        this.name = name;  
        this.age = age;
        this.email = email;
        this.amount = amount;

    }

    public Employee(String name, int age, String email) {

        System.out.println("called");
        this.name = name;
        this.age = age;
        this.email = email;

    } 
    
    public String getName() {
        return name;
    }                   
    public void setName(String name) {
        this.name = name;
    }   

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }   
    public String getEmail() {
        return email;
    }   

    public void setEmail(String email) {
        this.email = email;
    }   

    public String getEmail(String email) {
        return email;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public Long getId() {
        return id;
    }

    public String getDepartmentName() {
        return department.getName();
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }   

}
