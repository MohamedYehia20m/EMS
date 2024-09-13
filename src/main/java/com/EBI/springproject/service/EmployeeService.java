package com.EBI.springproject.service;

import com.EBI.springproject.Exception.GlobalException;
import com.EBI.springproject.model.EmployeeDto;
import com.EBI.springproject.model.EmployeeSaveDto;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployeeById(Long id);

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeSaveDto patchUpdateEmployee(EmployeeSaveDto employeeSaveDtoDto) ;

    EmployeeSaveDto UpdateEmployee(EmployeeSaveDto employeeSaveDto);

    void deleteEmployee(Long id);
}
