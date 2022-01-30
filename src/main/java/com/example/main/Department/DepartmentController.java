package com.example.main.Department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "api/v1/department")
public class DepartmentController {

    private final DepartmentService departmentService;
    private List<Department> department;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService =  departmentService;
    }

    @GetMapping
	public List<Department> firstCaller(){
        department = departmentService.getDepartment();
        return department;
	}

    @PostMapping
    public void addDepartment(@RequestBody Department department){
        departmentService.addNewDepartment(department);
    }

    @DeleteMapping(path = "{departmentId}")
    public void deleteDepartment(@PathVariable Long departmentId){
        departmentService.deleteDepartment(departmentId);
    }
    @PutMapping(path = "{departmentId}")

    public void updateDepartment(@PathVariable Long departmentId, @RequestParam (required = false) String name){
        departmentService.updateDepartment(departmentId, name);
    }
    
}
