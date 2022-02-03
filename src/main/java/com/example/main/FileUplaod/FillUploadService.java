package com.example.main.FileUplaod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.example.main.Employee.Employee;
import com.example.main.Employee.EmployeeService;

import org.hibernate.loader.plan.exec.process.spi.ReturnReader;
import org.springframework.scheduling.annotation.Async;

// import java.util.List;
// import java.util.concurrent.CompletableFuture;

// import com.example.main.Employee.Employee;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FillUploadService {

    private final EmployeeService employeeService;


    public FillUploadService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public static List<Employee> csvToEmployee(MultipartFile file) {

        List<Employee> employees = new ArrayList<Employee>();
        try{
            boolean isFirst = true;
            BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
            String line = "";
            while((line = br.readLine()) != null){
                if(isFirst){
                    isFirst = false;
                    continue;
                }
                
                final String[] fileData = line.split(",");
                Employee employee = new Employee(fileData[0], Integer.valueOf(fileData[2]), fileData[1]);
                employees.add(employee);

            }

            return employees;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;


        
    }

    @Async
    public void addInDb(List<Employee> employees, int count){
        System.err.println(count);
        for(Employee employee : employees){
            System.out.println(employee.getName()+ ":" + count);
            sleep(1, count);
            employeeService.registorNewEmployee(employee);
        }

    }


    @Async
    public void saveUser(MultipartFile file, int count) {
        List<Employee> employees = csvToEmployee(file);
        System.out.println(employees);
        // for(Employee employee : employees){
        //     System.out.println(employee.getName()+ ":" + count);
        //     sleep(1, count);
        //     employeeService.registorNewEmployee(employee);
        // }
        // Divide in 10-10 Grp.

        List<Employee> employeeList = new ArrayList<Employee>();

        for(Employee employee : employees){
            System.out.println(employee.getName());

            // If grp size is 10 then make a another thread.
            if(employeeList.size() == 10){
                System.out.println("calling");
                addInDb(employeeList, count);
                employeeList.clear();

            }
            employeeList.add(employee);
        }

        // If grp size is not the multiple of 10 then make a another thread, for remaining employees objects
        if(employeeList.size() > 0){
            addInDb(employeeList, count);
        }

    }


    


    @Async
    public void updateTheEmployeeDetails(Long employeeId, String name) {

        employeeService.updateEmployee(employeeId, name);
    }


    
    
    public static void sleep(int seconds, int count){
        try{
            if(count == 1){

                TimeUnit.SECONDS.sleep(seconds);
            }
            else{
                TimeUnit.SECONDS.sleep(seconds*2);

            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }



    
}
