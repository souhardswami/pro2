# Getting Started


## Steps To Run Project
* Run MainApplication inside (com.example.main) package as a Java Application
* Make a My-sql Connections


# Employee

* It has 5 field/Columns (Table in Employee.java)
    1. Id(primary key)
    2. name
    3. age
    4. email
    5. Respective Department(Foriegn_Key)

* Get all employees
     * Make a GET request to http://localhost:8080/api/v1/employee

* Add a new employee
     * Make a POST request to http://localhost:8080/api/v1/employeee  with an employee(JSON) in body

* Update an employee
     * Make a PUT request to http://localhost:8080/api/v1/employee/{"employeeId"}  with an employee(JSON) in body

* Delete an employee
     * Make a DELETE request to http://localhost:8080/api/v1/employee/{"employeeId"}
      

# Department

* It has 3 field/Columns (Table in Department.java)
    1. id(primary key)
    2. name
    3. is_tech

* Get all departments details(Get Request)
    * Make a GET request to http://localhost:8080/api/v1/department

* Add a new department(Post Request)
     * Make a POST request to http://localhost:8080/api/v1/department  with a department(JSON) in body

* Update a department
     * Make a PUT request to http://localhost:8080/api/v1/department/{"departmentId"} with a department(JSON) in body

* Delete a department
     * Make a DELETE request to http://localhost:8080/api/v1/department/{"departmentId"}


# Hibernate relationship

* Department and employee have many to one relationship.
* many to one realtion between Employee to Department.

## Database
* DB used is mysql
* Configure in application.properties(JPA- dependancy)
* Username - root
* Password - password

# Payment - Transactional

* A department has fund and it can pay to its employees(amount)
* Make a payment
    * Send a POST request to http://localhost:8080/api/v1/payment along with a payment(JSON) in body
    * Payment includes employeeId and the amount to be transferred from department's fund to employee amount
    


## Exception Handling & Logging

* Custom Exception Handles.
* Exception(ApiExceptionHandler) used to exception payload.
* Log4j : Logging/Monitor in console.


## MultiThreading

* FileUplaod used for MultiThreading
* Multiparts[] Files uploading 
     - More than one file can upload and saved in DB.
* Divided the file in chunk of 10 record and created multiple Thread pool.
