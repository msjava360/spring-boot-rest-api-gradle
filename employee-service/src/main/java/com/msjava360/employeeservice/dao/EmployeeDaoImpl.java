package com.msjava360.employeeservice.dao;

import com.msjava360.employeeservice.entity.Employee;
import com.msjava360.employeeservice.exception.ResourceNotFoundException;
import com.msjava360.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee findByEmployeeId(long employeeId) {
        //return findByEmployeeId(employeeId);
        return findByEmpId(employeeId);
    }

    private Employee findByEmpId(long employeeId) {
        Optional<Employee> employeeDB = this.employeeRepository.findById(employeeId);
        if (employeeDB.isPresent()) {
            Employee emp = employeeDB.get();
            return emp;
        } else {
            throw new ResourceNotFoundException("Record not found with this employee Id : "
                    + employeeId);
        }
    }

    @Override
    public List<Employee> findAllEmployee() {
        return this.employeeRepository.findAll();
    }

    @Override
    public List<Employee> findEmployeeByDeptId(long departmentId) {
        return this.employeeRepository.findAllByDepartmentId(departmentId);
        //return findByDeptId(departmentId);
    }

    private List<Employee> findByDeptId(long departmentId) {
        List<Employee> empList = this.employeeRepository.findAll();
        return empList
                .stream()
                .filter(e -> e.getDepartmentId().equals(departmentId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> findEmployeeByOrgId(long organizationId) {
        return this.employeeRepository.findAllByOrganizationId(organizationId);
        //return findByOrgId(organizationId);
    }

    private List<Employee> findByOrgId(long organizationId) {
        List<Employee> empList = this.employeeRepository.findAll();
        return empList
                .stream()
                .filter(e -> e.getOrganizationId().equals(organizationId))
                .collect(Collectors.toList());
    }

    @Override
    public Employee updateEmployeeByEmpIdPut(Employee employee) {
        Employee empUpdate = findByEmpId(employee.getEmployeeId());
        empUpdate.setEmployeeId(employee.getEmployeeId());
        empUpdate.setEmployeeName(employee.getEmployeeName());
        empUpdate.setEmployeeDob(employee.getEmployeeDob());
        empUpdate.setEmployeeDesignation(employee.getEmployeeDesignation());
        empUpdate.setEmployeeCity(employee.getEmployeeCity());
        empUpdate.setDepartmentId(employee.getDepartmentId());
        empUpdate.setOrganizationId(employee.getOrganizationId());
        this.employeeRepository.save(empUpdate);
        return empUpdate;
    }


    @Override
    public Employee updateEmployeeByEmpIdPatch(Employee employee) {
/*        Employee empUpdate = findByEmpId(employee.getEmployeeId());
        empUpdate.setEmployeeId(employee.getEmployeeId());
        empUpdate.setEmployeeName(employee.getEmployeeName());
        empUpdate.setEmployeeDob(employee.getEmployeeDob());
        empUpdate.setEmployeeDesignation(employee.getEmployeeDesignation());
        empUpdate.setEmployeeCity(employee.getEmployeeCity());
        empUpdate.setDepartmentId(employee.getDepartmentId());
        empUpdate.setOrganizationId(employee.getOrganizationId());*/
        this.employeeRepository.save(employee);
        return employee;
    }

    @Override
    public void deleteEmployee(long employeeId) {
        Employee emp = findByEmpId(employeeId);
        this.employeeRepository.deleteById(emp.getEmployeeId());
    }
}
