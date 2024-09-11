package com.EBI.springproject.service;

import com.EBI.springproject.model.EmployeeDto;

public interface EmployeeService {

    public EmployeeDto getEmployee( String id, String name, String salary);
}
