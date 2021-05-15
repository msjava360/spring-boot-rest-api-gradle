package com.msjava360.employeeservice.mapper;

import com.msjava360.employeeservice.dto.EmployeeDTO;
import com.msjava360.employeeservice.entity.Employee;
import com.msjava360.employeeservice.model.EmployeeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO getModelFromEntity(Employee employee);

    Employee getEntityFromModel(EmployeeDTO employeeDTO);

    Employee getEntityFromModelRequest(EmployeeRequest employeeRequest);
}
