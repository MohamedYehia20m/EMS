package com.EBI.springproject.service;

import com.EBI.springproject.model.EmployeeDto;
import com.EBI.springproject.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeRepo employeeRepo;
    final ModelMapper modelMapper;

    @Override
    public EmployeeDto getEmployee( String id, String name, String salary) {
        System.out.println(id);
        return modelMapper.map(employeeRepo.getEmployee( id, name, salary),EmployeeDto.class);
    }
}
