package com.msjava360.employeeservice.services;

import com.msjava360.employeeservice.dao.EmployeeDao;
import com.msjava360.employeeservice.dto.EmployeeDTO;
import com.msjava360.employeeservice.entity.Employee;
import com.msjava360.employeeservice.model.EmployeeRequest;
import com.msjava360.employeeservice.model.EmployeeResponse;
import com.msjava360.employeeservice.mapper.EmployeeMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger Log = LogManager.getLogger();
    private EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);


    @Autowired
    EmployeeDao employeeDao;

    @Override
    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) {
        // Employee emp = EmployeeMapper.MAPPER.getEntityFromModelRequest(employeeRequest);
        Employee emp = employeeMapper.getEntityFromModelRequest(employeeRequest);
        Employee employee = employeeDao.addEmployee(emp);
        EmployeeDTO modelFromEntity = employeeMapper.getModelFromEntity(employee);
        return new EmployeeResponse(Collections.singletonList(modelFromEntity));
    }

    @Override
    public EmployeeResponse findByEmployeeId(long employeeId) {
        Employee employee = employeeDao.findByEmployeeId(employeeId);
        EmployeeDTO modelFromEntity = employeeMapper.getModelFromEntity(employee);
        return new EmployeeResponse(Collections.singletonList(modelFromEntity));
    }

    @Override
    public EmployeeResponse findAllEmployee() {
        List<Employee> allEmployee = employeeDao.findAllEmployee();
        return new EmployeeResponse(getEmployeeDTOS(allEmployee));
    }

    @Override
    public EmployeeResponse findEmployeeByDeptId(long departmentId) {
        List<Employee> allEmployee = employeeDao.findEmployeeByDeptId(departmentId);
        return new EmployeeResponse(getEmployeeDTOS(allEmployee));
    }

    @Override
    public EmployeeResponse findEmployeeByOrgId(long organizationId) {
        List<Employee> allEmployee = employeeDao.findEmployeeByOrgId(organizationId);
        return new EmployeeResponse(getEmployeeDTOS(allEmployee));
    }

    @Override
    public EmployeeResponse updateEmployeeByEmpIdPut(EmployeeRequest employeeRequest) {
        Employee emp = employeeMapper.getEntityFromModelRequest(employeeRequest);
        Employee employee = employeeDao.updateEmployeeByEmpIdPut(emp);
        EmployeeDTO modelFromEntity = employeeMapper.getModelFromEntity(employee);
        return new EmployeeResponse(Collections.singletonList(modelFromEntity));
    }

    @Override
    public EmployeeResponse updateEmployeeByEmpIdPatch(EmployeeRequest employeeRequest) {
        Employee emp = employeeMapper.getEntityFromModelRequest(employeeRequest);
        Employee employee = employeeDao.updateEmployeeByEmpIdPatch(emp);
        EmployeeDTO modelFromEntity = employeeMapper.getModelFromEntity(employee);
        return new EmployeeResponse(Collections.singletonList(modelFromEntity));
    }

    @Override
    public void deleteEmployee(long employeeId) {
        employeeDao.deleteEmployee(employeeId);
    }

    private List<EmployeeDTO> getEmployeeDTOS(List<Employee> allEmployee) {
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for (Employee emp : allEmployee) {
            EmployeeDTO modelFromEntity = employeeMapper.getModelFromEntity(emp);
            employeeDTOS.add(modelFromEntity);
        }
        return employeeDTOS;
    }
}
