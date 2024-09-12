package com.EBI.springproject.service;

import com.EBI.springproject.Entity.EmployeeEntity;
import com.EBI.springproject.Entity.TaskEntity;
import com.EBI.springproject.model.EmployeeDto;
import com.EBI.springproject.model.EmployeeSaveDto;
import com.EBI.springproject.model.TaskDto;
import com.EBI.springproject.model.TaskSaveDto;
import com.EBI.springproject.repo.EmployeeRepo;
import com.EBI.springproject.repo.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{

    final TaskRepo taskRepo;
    final ModelMapper modelMapper;
    final EmployeeRepo employeeRepo;

    public TaskDto addTask(TaskDto taskDto) {
        TaskEntity taskEntity = taskRepo.save(modelMapper.map(taskDto, TaskEntity.class));
        return modelMapper.map(taskEntity, TaskDto.class);
    }

    public TaskSaveDto patchUpdate(TaskSaveDto taskSaveDto) {
        TaskEntity savedTaskEntity = null;


        if (taskSaveDto != null) {
            Optional<TaskEntity> taskEntityOptional = taskRepo.findById( taskSaveDto.getId());
            if (taskEntityOptional.isPresent()) {
                if(taskSaveDto.getDate() != null)
                {
                    taskEntityOptional.get().setDate(taskSaveDto.getDate());
                }

                if (taskSaveDto.getDescription() != null)
                {
                    taskEntityOptional.get().setDescription(taskSaveDto.getDescription());
                }

                if (taskSaveDto.getName() != null)
                {
                    taskEntityOptional.get().setName(taskSaveDto.getName());
                }

                if (taskSaveDto.getEmployeeId() != null)
                {
                    Optional<EmployeeEntity> employeeEntityOptional = employeeRepo.findById(taskSaveDto.getEmployeeId());
                    if (employeeEntityOptional.isPresent()){
                        taskEntityOptional.get().setEmployeeEntity(employeeEntityOptional.get());
                    }
                }
                savedTaskEntity = taskRepo.save(taskEntityOptional.get());
            }

        }

        return modelMapper.map(savedTaskEntity, TaskSaveDto.class);
    }
}
