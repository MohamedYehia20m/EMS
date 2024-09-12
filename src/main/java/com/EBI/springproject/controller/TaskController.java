package com.EBI.springproject.controller;


import com.EBI.springproject.model.TaskDto;
import com.EBI.springproject.model.TaskSaveDto;
import com.EBI.springproject.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {

    final TaskService taskService;

    @PostMapping
    TaskDto addTask(@RequestBody TaskDto taskDto){
        return taskService.addTask(taskDto);
    }

    @PatchMapping
    TaskSaveDto patchUpdate(@RequestBody TaskSaveDto taskSaveDto){
        return taskService.patchUpdate(taskSaveDto);

    }
}
