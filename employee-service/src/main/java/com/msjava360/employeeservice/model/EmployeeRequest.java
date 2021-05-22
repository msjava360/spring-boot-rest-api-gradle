package com.msjava360.employeeservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class EmployeeRequest {

    private Long employeeId;

    private String employeeName;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date employeeDob;

    private String employeeDesignation;

    private String employeeCity;

    private Long organizationId;

    private Long departmentId;

}
