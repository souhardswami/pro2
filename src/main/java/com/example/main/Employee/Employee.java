package com.example.main.Employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    @ManyToOne
    private Department department;

    public Employee() {
    }

    public Employee(String name, int age, String email, Long id ) {
        this.id = id;
        this.name = name;  
        this.age = age;
        this.email = email;


    }

    public Employee(String name, int age, String email) {
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

    public Long getId() {
        return id;
    }

    public String getDepartmentName() {
        return department.getName();
    }
}