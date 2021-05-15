package com.msjava360.employeeservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDTO {

    @JsonProperty("employee_id")
    private Long employeeId;

    @JsonProperty("employee_name")
    private String employeeName;

    @JsonProperty("employee_dob")
    private Date employeeDob;

    @JsonProperty("employee_designation")
    private String employeeDesignation;

    @JsonProperty("employee_city")
    private String employeeCity;

    @JsonProperty("organization_id")
    private Long organizationId;

    @JsonProperty("department_id")
    private Long departmentId;
}
