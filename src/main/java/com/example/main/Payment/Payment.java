package com.example.main.Payment;

public class Payment {

    private Long employeeId;
    private Long amount;

    public Payment() {
    }

    public Payment(Long employeeId, Long amount) {
        this.employeeId = employeeId;
        this.amount = amount;
    }   
    public Long getEmployeeId() {
        return employeeId;
    }   
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }   
    public Long getAmount() {
        return amount;
    }   
    public  void setAmount(Long amount) {
        this.amount = amount;
    }

}
