package com.EBI.springproject.service;

import com.EBI.springproject.model.EmployeeDto;
import com.EBI.springproject.Entity.EmployeeEntity;
import com.EBI.springproject.model.EmployeeSaveDto;
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


    public EmployeeSaveDto patchUpdateEmployee(EmployeeSaveDto employeeSaveDto) {
        EmployeeEntity savedEmployeeEntity = null;


        if (employeeSaveDto != null) {
            Optional<EmployeeEntity> employeeEntityOptional = employeeRepo.findById((long) employeeSaveDto.getId());
            if (employeeEntityOptional.isPresent()) {
                if(employeeSaveDto.getSalary() != null)
                {
                    employeeEntityOptional.get().setSalary(employeeSaveDto.getSalary());
                }

                if (employeeSaveDto.getFirst_Name() != null)
                {
                    employeeEntityOptional.get().setFirst_Name(employeeSaveDto.getFirst_Name());
                }
                if (employeeSaveDto.getSecond_Name() != null)
                {
                    employeeEntityOptional.get().setSecond_Name(employeeSaveDto.getSecond_Name());
                }
                savedEmployeeEntity = employeeRepo.save(employeeEntityOptional.get());
            }

        }

        return modelMapper.map(savedEmployeeEntity, EmployeeSaveDto.class);
    }

    public EmployeeSaveDto UpdateEmployee(EmployeeSaveDto employeeSaveDto) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeSaveDto, EmployeeEntity.class);
        EmployeeEntity employeeEntity1 = employeeRepo.save(employeeEntity);
        return modelMapper.map(employeeEntity1, EmployeeSaveDto.class);


    }

    public void deleteEmployee(Long id) {
        EmployeeEntity employeeEntity = employeeRepo.findById(id).orElse(null);
        employeeRepo.delete(employeeEntity);
    }
}
