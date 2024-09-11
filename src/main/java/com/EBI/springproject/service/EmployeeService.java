package com.EBI.springproject.service;

import com.EBI.springproject.model.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployeeById(Long id);

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto patchUpdateEmployee(EmployeeDto employeeDto ,Long id);

    EmployeeDto UpdateEmployee(EmployeeDto employeeDto , Long id);

    Boolean deleteEmployee(Long id);
}
