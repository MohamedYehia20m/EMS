package com.EBI.springproject.service;

import com.EBI.springproject.model.EmployeeDto;
import com.EBI.springproject.Entity.EmployeeEntity;
import com.EBI.springproject.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeRepo employeeRepo;
    final ModelMapper modelMapper;

    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepo.findAll();
        List<EmployeeDto> employeeDtos = new ArrayList<>();

        employeeDtos = employeeEntities.stream().map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDto.class)).collect(Collectors.toList());

        return employeeDtos;
    }

    public EmployeeDto getEmployeeById(Long id) {
        Optional<EmployeeEntity> employeeEntity = employeeRepo.findById(id);
        return employeeEntity.map(entity -> modelMapper.map(entity, EmployeeDto.class)).orElse(null);
    }

    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = employeeRepo.save(modelMapper.map(employeeDto, EmployeeEntity.class));
        return modelMapper.map(employeeEntity, EmployeeDto.class);
    }


    public EmployeeDto patchUpdateEmployee(EmployeeDto employeeDto, Long id) {
        EmployeeDto employeeDto1;
        EmployeeEntity employeeEntity = modelMapper.map(this.getEmployeeById(id), EmployeeEntity.class);

        if (employeeDto != null) {
            if(employeeDto.getSalary() != null)
            {
                employeeEntity.setSalary(employeeDto.getSalary());
            }

            if (employeeDto.getFirst_Name() != null)
            {
                employeeEntity.setFirst_Name(employeeDto.getFirst_Name());
            }
            if (employeeDto.getSalary() != null)
            {
                employeeEntity.setSalary(employeeDto.getSalary());
            }
            //TODO save in database
            employeeRepo.save(employeeEntity);


        }
        employeeDto1 = modelMapper.map(employeeEntity, EmployeeDto.class);
        return employeeDto1;
    }

    public EmployeeDto UpdateEmployee(EmployeeDto employeeDto, Long id) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
        employeeEntity.setId(id);
        EmployeeEntity employeeEntity1 = employeeRepo.save(employeeEntity);
        return modelMapper.map(employeeEntity1, EmployeeDto.class);


    }

    public void deleteEmployee(Long id) {
        EmployeeEntity employeeEntity = employeeRepo.findById(id).orElse(null);
        employeeRepo.delete(employeeEntity);
    }
}
