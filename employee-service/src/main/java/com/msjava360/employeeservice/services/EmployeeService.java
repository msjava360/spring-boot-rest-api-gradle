package com.msjava360.employeeservice.services;

import com.msjava360.employeeservice.model.EmployeeRequest;
import com.msjava360.employeeservice.model.EmployeeResponse;

public interface EmployeeService {

    EmployeeResponse addEmployee(EmployeeRequest employeeRequest);

    EmployeeResponse findByEmployeeId(long employeeId);

    EmployeeResponse findAllEmployee();

    EmployeeResponse findEmployeeByDeptId(long departmentId);

    EmployeeResponse findEmployeeByOrgId(long organizationId);

    EmployeeResponse updateEmployeeByEmpIdPut(EmployeeRequest employeeRequest);

    EmployeeResponse updateEmployeeByEmpIdPatch(EmployeeRequest employeeRequest);

    void deleteEmployee(long id);

}
