package com.msjava360.employeeservice.dao;

import com.msjava360.employeeservice.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee addEmployee(Employee employeeRequest);

    Employee findByEmployeeId(long employeeId);

    List<Employee> findAllEmployee();

    List<Employee> findEmployeeByDeptId(long departmentId);

    List<Employee> findEmployeeByOrgId(long organizationId);

    Employee updateEmployeeByEmpIdPut(Employee employee);

    Employee updateEmployeeByEmpIdPatch(Employee employee);

    void deleteEmployee(long id);
}
