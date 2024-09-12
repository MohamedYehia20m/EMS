package com.EBI.springproject.model;


import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaskSaveDto {
    private Long id;
    private String name;
    private String description;
    private String date;
    private Long employeeId;
}
