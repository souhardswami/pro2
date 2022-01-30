package com.example.main.Department;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private Long departmentId;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getDepartment(){

        // System.out.println("This funcation is running");
        if(departmentRepository.findAll().size() > 0 ){

            // Print all Employee
            // for(Employee employee:employeeRepository.findAll()){        
            //         System.out.println(employee.getName());  
            // }

            return departmentRepository.findAll();
        }
        return null;
    }

    public void addNewDepartment(Department department) {
        departmentRepository.save(department);
    }

    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    public void updateDepartment(Long departmentId, String name) {
            
        if(name != null){
                                                                            
                // List out all the employees..
                List<Department> departments =   departmentRepository.findAll();
                for(Department department:departments){
                    this.departmentId = departmentId;
    
                    // Update the employee with given id.
                    if(department.getId() == this.departmentId){
                        department.setName(name);
                        departmentRepository.save(department);
                    }
                }                                                   
        }


    }



    
}
