package com.example.main.Department;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "department")
@Table
public class Department {
    
    @Id
    @SequenceGenerator(
            name = "dapartment_seq",
            sequenceName = "department_seq",
            allocationSize = 1                                              
    )

    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "department_seq"
    )
    private Long id;

    private String name;
    private boolean isTech;
    private Long fund;

    public Department() {
    }
    
    public Department(String name, boolean isTech) {
        this.name = name;
        this.isTech = isTech;
    }   

    public Department(Long id, String name, boolean isTech) {
        this.id = id;
        this.name = name;
        this.isTech = isTech;
    }

    public Long getId() {
        return id;
    }
    public boolean isTech() {
        return isTech;
    }
    public void setTech(boolean isTech) {
        this.isTech = isTech;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getFund() {
        return fund;
    }   
    public void setFund(Long fund) {
        this.fund = fund;
    }
    
}
