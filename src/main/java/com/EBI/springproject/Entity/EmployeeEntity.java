package com.EBI.springproject.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.modelmapper.internal.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")


public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String first_Name;
    private String Salary;
    private String second_Name;
}
