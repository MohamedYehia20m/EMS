package com.EBI.springproject.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class EmployeeDto {
    private String Name;
    private String Salary;


}
