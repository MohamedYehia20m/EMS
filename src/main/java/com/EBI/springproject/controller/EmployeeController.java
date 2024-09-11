package com.EBI.springproject.controller;

import com.EBI.springproject.model.EmployeeDto;
import com.EBI.springproject.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;


    @ResponseBody
    @GetMapping("/getEmployee/{id}")
    public EmployeeDto getEmployee(@PathVariable String id, @RequestParam String name, @RequestParam String salary) {
        return employeeServiceImpl.getEmployee(id,name,salary);
    }

    @ResponseBody
    @GetMapping("/getMethod")
    public String getEmployeeView() {
        return "employeee";
    }

    @ResponseBody
    @PostMapping("/postMethod")

    public EmployeeDto getEmployeePost(@RequestBody EmployeeDto employeeDto) {
        return employeeDto;
    }


}
