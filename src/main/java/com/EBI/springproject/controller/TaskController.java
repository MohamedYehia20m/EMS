package com.EBI.springproject.controller;


import com.EBI.springproject.model.GeneralResponse;
import com.EBI.springproject.model.TaskDto;
import com.EBI.springproject.model.TaskSaveDto;
import com.EBI.springproject.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {

    final TaskService taskService;

    @Value("${success.code}")
    String successCode;

    @Value("${success.message}")
    String successMessage;

    @PostMapping
    ResponseEntity<?> addTask(@RequestBody TaskDto taskDto){
        TaskDto taskDto1 = taskService.addTask(taskDto);
        GeneralResponse<TaskDto> response = new GeneralResponse<>(successCode,successMessage,taskDto1);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping
    ResponseEntity<?> patchUpdate(@RequestBody TaskSaveDto taskSaveDto){
        TaskSaveDto taskSaveDto1 = taskService.patchUpdate(taskSaveDto);
        GeneralResponse<TaskSaveDto> response = new GeneralResponse<>(successCode,successMessage,taskSaveDto1);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("{employeeId}")
    ResponseEntity<?> getAllTasksByEmployee(@PathVariable Long employeeId){
        List<TaskDto> taskDtos = taskService.getAllTasksByEmployee(employeeId);
        GeneralResponse<List<TaskDto>> response = new GeneralResponse<>(successCode,successMessage,taskDtos);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
