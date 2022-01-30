package com.example.main.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private List<Employee> employee;
    
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService =  employeeService;
    }

    @GetMapping
	public List<Employee> firstCaller(){
        employee = employeeService.getEmployee();
        return employee;
	}
    
    @PostMapping
    public void registorEmployee(@RequestBody Employee employee){
        employeeService.registorNewEmployee(employee);
    }

    @DeleteMapping(path = "{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId){
        employeeService.deleteEmployee(employeeId);
    }

    @PutMapping(path = "{employeeId}")
    public void updateEmployee(@PathVariable Long employeeId, @RequestParam (required = false) String name){
        employeeService.updateEmployee(employeeId, name);
    }
}
