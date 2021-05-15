package com.msjava360.employeeservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeRequest {

    private Long employeeId;

    private String employeeName;

    private Date employeeDob;

    private String employeeDesignation;

    private String employeeCity;

    private Long organizationId;

    private Long departmentId;

}
