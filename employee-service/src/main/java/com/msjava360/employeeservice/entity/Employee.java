package com.msjava360.employeeservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "employe_dob")
    private Date employeeDob;

    @Column(name = "employee_designation")
    private String employeeDesignation;

    @Column(name = "employee_city")
    private String employeeCity;

    @Column(name = "organization_id")
    private Long organizationId;

    @Column(name = "department_id")
    private Long departmentId;

    public Employee() {
    }

    /*public Employee(Long employeeId, String employeeName, Date employeeDob, String employeeDesignation, String employeeCity, Long organizationId, Long departmentId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeDob = employeeDob;
        this.employeeDesignation = employeeDesignation;
        this.employeeCity = employeeCity;
        this.organizationId = organizationId;
        this.departmentId = departmentId;
    }*/
}
