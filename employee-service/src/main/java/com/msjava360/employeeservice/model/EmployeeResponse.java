package com.msjava360.employeeservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.msjava360.employeeservice.dto.EmployeeDTO;
import lombok.Builder;

import java.util.List;


@Builder
@JacksonXmlRootElement(localName = "employeeResponse")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = false)
public class EmployeeResponse {

    private List<EmployeeDTO> employeeDtoList;

    public EmployeeResponse(List<EmployeeDTO> employeeDtoList) {
        this.employeeDtoList = employeeDtoList;
    }

    public EmployeeResponse() {
    }

    @JacksonXmlElementWrapper(localName = "employees")
    @JacksonXmlProperty(localName = "employees")
    public List<EmployeeDTO> getEmployeeDtoList() {
        return employeeDtoList;
    }

    public void setEmployeeDtoList(List<EmployeeDTO> employeeDtoList) {
        this.employeeDtoList = employeeDtoList;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("EmployeeResponse{")
                .append("employees=")
                .append(employeeDtoList)
                .append("}");
        return stringBuilder.toString();
    }
}

