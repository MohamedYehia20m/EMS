package com.EBI.springproject.repo;

import com.EBI.springproject.model.EmployeeDto;
import com.EBI.springproject.model.Entity.EmployeeEntity;

import java.util.List;

public interface EmployeeRepo {

    List<EmployeeEntity> getAllEmployees();

    EmployeeEntity getEmployeeById(Long id);

    EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);

    EmployeeEntity patchUpdateEmployee(EmployeeEntity employeeEntity ,Long id);

    EmployeeEntity UpdateEmployee(EmployeeEntity employeeEntity , Long id);

    Boolean deleteEmployee(Long id);
}
