package com.EBI.springproject.controller;

import com.EBI.springproject.model.EmployeeDto;
import com.EBI.springproject.model.EmployeeSaveDto;
import com.EBI.springproject.service.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    final EmployeeServiceImpl employeeServiceImpl;

    @GetMapping
    List<EmployeeDto> getAllEmployees() {
        return employeeServiceImpl.getAllEmployees();
    }

    @GetMapping("{id}")
    EmployeeDto getEmployeeById(@PathVariable Long id)
    {
        return employeeServiceImpl.getEmployeeById(id);
    }

    @PostMapping
    EmployeeDto saveEmployee(@RequestBody EmployeeDto employeeDto)
    {
        return employeeServiceImpl.saveEmployee(employeeDto);
    }

    @PatchMapping
    EmployeeSaveDto patchUpdateEmployee(@RequestBody EmployeeSaveDto employeeSaveDto)
    {
        return employeeServiceImpl.patchUpdateEmployee(employeeSaveDto);
    }

    @PutMapping
    EmployeeSaveDto UpdateEmployee(@RequestBody EmployeeSaveDto employeeSaveDto)
    {
        return employeeServiceImpl.UpdateEmployee(employeeSaveDto);
    }

    @DeleteMapping("{id}")
    void deleteEmployee(@PathVariable Long id)
    {

        employeeServiceImpl.deleteEmployee(id);
    }
}
