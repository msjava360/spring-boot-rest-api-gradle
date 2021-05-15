package com.msjava360.employeeservice.controller;

import com.msjava360.employeeservice.model.EmployeeRequest;
import com.msjava360.employeeservice.model.EmployeeResponse;
import com.msjava360.employeeservice.services.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private static final Logger Log = LogManager.getLogger();

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/add/employee",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody EmployeeRequest employeeRequest) {
        EmployeeResponse employeeResponse = employeeService.addEmployee(employeeRequest);
        return new ResponseEntity<>(employeeResponse, HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/employee/{empId}"
    )
    public ResponseEntity<EmployeeResponse> findByEmployeeId(@PathVariable("empId") long employeeId) {
        EmployeeResponse employeeResponse = employeeService.findByEmployeeId(employeeId);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/all/employee"
    )
    public ResponseEntity<EmployeeResponse> findAllEmployee() {
        EmployeeResponse employeeResponse = employeeService.findAllEmployee();
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/employee/dept/{deptId}"
    )
    public ResponseEntity<EmployeeResponse> findEmployeeByDeptId(@PathVariable("deptId") long departmentId) {
        EmployeeResponse employeeResponse = employeeService.findEmployeeByDeptId(departmentId);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/employee/org/{orgId}"
    )
    public ResponseEntity<EmployeeResponse> findEmployeeByOrgId(@PathVariable("orgId") long organizationId) {
        EmployeeResponse employeeResponse = employeeService.findEmployeeByOrgId(organizationId);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/employee/{empId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<EmployeeResponse> updateEmployeeByEmpIdPut(@PathVariable("empId") long employeeId, @RequestBody EmployeeRequest employeeRequest) {
        employeeRequest.setEmployeeId(employeeId);
        EmployeeResponse employeeResponse = employeeService.updateEmployeeByEmpIdPut(employeeRequest);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.PATCH,
            value = "/employee/{empId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<EmployeeResponse> updateEmployeeByEmpIdPatch(@PathVariable("empId") long employeeId, @RequestBody EmployeeRequest employeeRequest) {
        employeeRequest.setEmployeeId(employeeId);
        EmployeeResponse employeeResponse = employeeService.updateEmployeeByEmpIdPatch(employeeRequest);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/employee/{empId}"
    )
    public ResponseEntity<?> deleteEmployee(@PathVariable("empId") long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
    }
}
