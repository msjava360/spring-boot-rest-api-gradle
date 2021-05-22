package com.msjava360.employeeservice.dao;

import com.msjava360.employeeservice.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao {
    Employee addEmployee(Employee employee);

    Employee findByEmployeeId(long employeeId);

    List<Employee> findAllEmployee();

    List<Employee> findEmployeeByDeptId(long departmentId);

    List<Employee> findEmployeeByOrgId(long organizationId);

    Employee updateEmployeeByEmpIdPut(Employee employee);

    Employee updateEmployeeByEmpIdPatch(Employee employee);

    void deleteEmployee(long id);
}
