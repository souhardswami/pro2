package com.example.main.Employee;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

 
    private final EmployeeRepository employeeRepository;
    private Long employeeId;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployee(){

        // System.out.println("This funcation is running");
        if(employeeRepository.findAll().size() > 0 ){

            // Print all Employee
            // for(Employee employee:employeeRepository.findAll()){        
            //         System.out.println(employee.getName());  
            // }

            return employeeRepository.findAll();
        }
        return null;
    }

    public void registorNewEmployee(Employee employee){

        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId){
                    
        employeeRepository.deleteById(employeeId);                                                                                                                                                            
    }

    public void updateEmployee(Long employeeId, String name) {

        if(name != null){

            // List out all the employees..
            List<Employee> employees =   employeeRepository.findAll();
            for(Employee employee:employees){
                this.employeeId = employeeId;

                // Update the employee with given id.
                if(employee.getId() == this.employeeId){
                    employee.setName(name);
                    employeeRepository.save(employee);
                }
            }
        }
    }
}
