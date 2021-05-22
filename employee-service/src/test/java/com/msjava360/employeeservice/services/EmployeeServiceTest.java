package com.msjava360.employeeservice.services;


import com.msjava360.employeeservice.dao.EmployeeDao;
import com.msjava360.employeeservice.entity.Employee;
import com.msjava360.employeeservice.model.EmployeeRequest;
import com.msjava360.employeeservice.model.EmployeeResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Date;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    EmployeeDao employeeDao;

    @InjectMocks
    EmployeeServiceImpl employeeService;

    EmployeeRequest employeeRequest;
    Employee employee;

    @BeforeEach
    public void setup() {
        employeeRequest = getEmployeeRequest();
        employee = getEmployee();
    }

    @Test
    public void addEmployee_should_return_success() {
        when(employeeDao.addEmployee(employee)).thenReturn(employee);
        EmployeeResponse employeeResponse = employeeService.addEmployee(employeeRequest);
        Assertions.assertEquals(employee.getEmployeeName(), employeeResponse.getEmployeeDtoList()
                .get(0).getEmployeeName());
        verify(employeeDao).addEmployee(employee);
    }


    private Employee getEmployee() {
        return new Employee(100L, "muthu",
                new Date(), "SSE", "madurai", 200L,
                300L);
    }

    private EmployeeRequest getEmployeeRequest() {
        return new EmployeeRequest(100L, "muthu",
                new Date(), "SSE", "madurai", 200L,
                300L);
    }
}
