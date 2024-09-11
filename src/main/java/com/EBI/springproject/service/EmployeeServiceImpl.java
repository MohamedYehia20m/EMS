package com.EBI.springproject.service;

import com.EBI.springproject.model.EmployeeDto;
import com.EBI.springproject.model.Entity.EmployeeEntity;
import com.EBI.springproject.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeRepo employeeRepo;
    final ModelMapper modelMapper;

    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepo.getAllEmployees();
        List<EmployeeDto> employeeDtos = new ArrayList<>();

        employeeDtos = employeeEntities.stream().map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDto.class)).collect(Collectors.toList());

        return employeeDtos;
    }

    public EmployeeDto getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepo.getEmployeeById(id);
        return modelMapper.map(employeeEntity, EmployeeDto.class);
    }

    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = employeeRepo.saveEmployee(modelMapper.map(employeeDto, EmployeeEntity.class));
        return modelMapper.map(employeeEntity, EmployeeDto.class);
    }

    public EmployeeDto patchUpdateEmployee(EmployeeDto employeeDto, Long id) {
        EmployeeEntity employeeEntity = modelMapper.map(this.getEmployeeById(id), EmployeeEntity.class);

        if (employeeDto != null) {
            if(employeeDto.getSalary() != null)
            {
                employeeEntity.setSalary(employeeDto.getSalary());
            }

            if (employeeDto.getName() != null)
            {
                employeeEntity.setName(employeeDto.getName());
            }
            //TODO save in database
        }
        return employeeDto;
    }

    public EmployeeDto UpdateEmployee(EmployeeDto employeeDto, Long id) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
        EmployeeEntity employeeEntity1 = employeeRepo.patchUpdateEmployee(employeeEntity , id);
        return modelMapper.map(employeeEntity1, EmployeeDto.class);


    }

    public Boolean deleteEmployee(Long id) {
        return employeeRepo.deleteEmployee(id);
    }
}
