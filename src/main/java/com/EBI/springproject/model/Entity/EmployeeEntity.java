package com.EBI.springproject.model.Entity;


import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Component
public class EmployeeEntity {
    private String Id;
    private String Name;
    private String Salary;
}
