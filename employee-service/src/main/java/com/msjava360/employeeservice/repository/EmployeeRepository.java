package com.msjava360.employeeservice.repository;

import com.msjava360.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByDepartmentId(long deptId);

    List<Employee> findAllByOrganizationId(long orgId);
}
