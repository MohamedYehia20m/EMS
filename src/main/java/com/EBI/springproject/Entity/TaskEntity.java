package com.EBI.springproject.Entity;


import jakarta.persistence.*;

import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String date;



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    EmployeeEntity employeeEntity;
}
