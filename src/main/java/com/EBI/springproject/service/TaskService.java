package com.EBI.springproject.service;

import com.EBI.springproject.model.TaskDto;
import com.EBI.springproject.model.TaskSaveDto;

public interface TaskService {
    TaskDto addTask(TaskDto taskDto);
    TaskSaveDto PatchUpdate(TaskSaveDto taskSaveDto);
}
