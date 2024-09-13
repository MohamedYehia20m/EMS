package com.EBI.springproject.controller;

import com.EBI.springproject.model.EmployeeDto;
import com.EBI.springproject.model.EmployeeSaveDto;
import com.EBI.springproject.model.GeneralResponse;
import com.EBI.springproject.service.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    final EmployeeServiceImpl employeeServiceImpl;

    @Value("${success.code}")
    String successCode;

    @Value("${success.message}")
    String successMessage;

    @GetMapping
    ResponseEntity<?> getAllEmployees() {
        List<EmployeeDto> employeeDtos = employeeServiceImpl.getAllEmployees();
        GeneralResponse<List<EmployeeDto>> response = new GeneralResponse<>(successCode,successMessage,employeeDtos);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{id}")
    ResponseEntity<?> getEmployeeById(@PathVariable Long id)
    {
        EmployeeDto employeeDto = employeeServiceImpl.getEmployeeById(id);
        GeneralResponse<EmployeeDto> response = new GeneralResponse<>(successCode,successMessage,employeeDto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<?> saveEmployee(@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto employeeDto1 = employeeServiceImpl.saveEmployee(employeeDto);
        GeneralResponse<EmployeeDto> response = new GeneralResponse<>(successCode,successMessage,employeeDto1);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping
    ResponseEntity<?> patchUpdateEmployee(@RequestBody EmployeeSaveDto employeeSaveDto)
    {
        EmployeeSaveDto employeeSaveDto1 = employeeServiceImpl.patchUpdateEmployee(employeeSaveDto);
        GeneralResponse<EmployeeSaveDto> response= new GeneralResponse<>(successCode,successMessage,employeeSaveDto1);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<?> UpdateEmployee(@RequestBody EmployeeSaveDto employeeSaveDto)
    {
        EmployeeSaveDto employeeSaveDto1 = employeeServiceImpl.UpdateEmployee(employeeSaveDto);
        GeneralResponse<EmployeeSaveDto> response= new GeneralResponse<>(successCode,successMessage,employeeSaveDto1);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    ResponseEntity<?> deleteEmployee(@PathVariable Long id)
    {
        employeeServiceImpl.deleteEmployee(id);
        GeneralResponse<String> response= new GeneralResponse<>(successCode,successMessage,"delete is Successful");

        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
}
