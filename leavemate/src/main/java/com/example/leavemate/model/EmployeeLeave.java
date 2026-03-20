package com.example.leavemate.model;

import jakarta.persistence.*;

@Entity
public class EmployeeLeave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeName;
    private String leaveType;
    private String status;

    public EmployeeLeave() {}

    public Long getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
