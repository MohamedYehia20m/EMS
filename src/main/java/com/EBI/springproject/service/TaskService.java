package com.EBI.springproject.service;

import com.EBI.springproject.model.TaskDto;
import com.EBI.springproject.model.TaskSaveDto;

import java.util.List;

public interface TaskService {
    TaskDto addTask(TaskDto taskDto);
    TaskSaveDto patchUpdate(TaskSaveDto taskSaveDto);

    List<TaskDto> getAllTasksByEmployee(Long employeeId);
}
