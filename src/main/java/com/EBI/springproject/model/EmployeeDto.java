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
    private String first_Name;
    private String Salary;
    private String second_Name;


}
