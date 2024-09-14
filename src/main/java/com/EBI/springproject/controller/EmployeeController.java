package com.EBI.springproject.controller;

import com.EBI.springproject.model.EmployeeDto;
import com.EBI.springproject.model.EmployeeSaveDto;
import com.EBI.springproject.model.GeneralResponse;
import com.EBI.springproject.repo.EmployeeRepo;
import com.EBI.springproject.service.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    final EmployeeServiceImpl employeeServiceImpl;

    final EmployeeRepo employeeRepo;

    @Value("${success.code}")
    String successCode;

    @Value("${success.message}")
    String successMessage;

    @ResponseBody
    @GetMapping
    ResponseEntity<?> getAllEmployees() {
        List<EmployeeDto> employeeDtos = employeeServiceImpl.getAllEmployees();
        GeneralResponse<List<EmployeeDto>> response = new GeneralResponse<>(successCode,successMessage,employeeDtos);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @GetMapping("/home")
    String getHomePage(Model model) {

        return "index";
    }


    @GetMapping("/view")
    String getAllEmployeesView(Model model) {
        List<EmployeeDto> employeeDtos = employeeServiceImpl.getAllEmployees();
        GeneralResponse<List<EmployeeDto>> response = new GeneralResponse<>(successCode,successMessage,employeeDtos);
        model.addAttribute("response",response);

        return "showAll";
    }

    @GetMapping("/search")
    String searchEmployeeByIdView(Model model) {
        model.addAttribute("employeeSaveDto",new EmployeeSaveDto());

        return "searchById";
    }

    @PostMapping("/search")
    String getAllEmployeesByIdView(EmployeeSaveDto employeeSaveDto , Model model) {
        EmployeeDto employeeDto = employeeServiceImpl.getEmployeeById((long) employeeSaveDto.getId());
        GeneralResponse<EmployeeDto> response = new GeneralResponse<>(successCode,successMessage,employeeDto);
        model.addAttribute("response",response);

        return "showAll";
    }

    @GetMapping("/register")
    String saveEmployeeView( Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());

        return "save";
    }

    @PostMapping("/register")
    String registerEmployee( EmployeeDto employeeDto , Model model) {
        EmployeeDto employeeDto1 = employeeServiceImpl.saveEmployee(employeeDto);
        model.addAttribute("employeeDto",new EmployeeDto());

        return "redirect:view";
    }


    @GetMapping("/patch")
    String patchEmployeeView( Model model) {
        model.addAttribute("employeeSaveDto",new EmployeeSaveDto());

        return "patch";
    }

//what if i use @PostMapping with Patch logic?
    @PostMapping("/patch")
    String patchEmployee(EmployeeSaveDto employeeSaveDto , Model model) {
        EmployeeSaveDto employeeSaveDto1 = employeeServiceImpl.patchEmployee(employeeSaveDto);
        GeneralResponse<EmployeeSaveDto> response= new GeneralResponse<>(successCode,successMessage,employeeSaveDto1);
        model.addAttribute("response", response);

        return  getAllEmployeesView(model);
    }

    @GetMapping("/update")
    String updateEmployeeView(Model model) {
        model.addAttribute("employeeSaveDto",new EmployeeSaveDto());

        return "update";
    }


    @PostMapping("/update")
    String updateEmployee(EmployeeSaveDto employeeSaveDto , Model model) {
        EmployeeSaveDto employeeSaveDto1 = employeeServiceImpl.UpdateEmployee(employeeSaveDto);
        GeneralResponse<EmployeeSaveDto> response= new GeneralResponse<>(successCode,successMessage,employeeSaveDto1);
        model.addAttribute("response", response);

        return getAllEmployeesView(model);
    }

    @GetMapping("/delete")
    String deleteEmployee(Model model)
    {
        model.addAttribute("employeeSaveDto",new EmployeeSaveDto());
        return "delete";
    }

    @PostMapping("/delete")
    String deleteEmployee( EmployeeSaveDto employeeSaveDto , Model model)
    {
        employeeServiceImpl.deleteEmployee((long) employeeSaveDto.getId());
        //GeneralResponse<String> response= new GeneralResponse<>(successCode,successMessage,"delete is Successful");

        return getAllEmployeesView(model);
    }







    @ResponseBody
    @GetMapping("{id}")
    ResponseEntity<?> getEmployeeById(@PathVariable Long id)
    {
        EmployeeDto employeeDto = employeeServiceImpl.getEmployeeById(id);
        GeneralResponse<EmployeeDto> response = new GeneralResponse<>(successCode,successMessage,employeeDto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @ResponseBody
    @PostMapping
    ResponseEntity<?> saveEmployee(@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto employeeDto1 = employeeServiceImpl.saveEmployee(employeeDto);
        GeneralResponse<EmployeeDto> response = new GeneralResponse<>(successCode,successMessage,employeeDto1);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ResponseBody
    @PatchMapping
    ResponseEntity<?> patchEmployee(@RequestBody EmployeeSaveDto employeeSaveDto) {
        EmployeeSaveDto employeeSaveDto1 = employeeServiceImpl.patchEmployee(employeeSaveDto);
        GeneralResponse<EmployeeSaveDto> response= new GeneralResponse<>(successCode,successMessage,employeeSaveDto1);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping
    ResponseEntity<?> UpdateEmployee(@RequestBody EmployeeSaveDto employeeSaveDto)
    {
        EmployeeSaveDto employeeSaveDto1 = employeeServiceImpl.UpdateEmployee(employeeSaveDto);
        GeneralResponse<EmployeeSaveDto> response= new GeneralResponse<>(successCode,successMessage,employeeSaveDto1);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ResponseBody
    @DeleteMapping("{id}")
    ResponseEntity<?> deleteEmployee(@PathVariable Long id)
    {
        employeeServiceImpl.deleteEmployee(id);
        GeneralResponse<String> response= new GeneralResponse<>(successCode,successMessage,"delete is Successful");

        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
}
