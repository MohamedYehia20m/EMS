package com.EBI.springproject.repo;

import com.EBI.springproject.Entity.EmployeeEntity;
import com.EBI.springproject.Entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepo extends JpaRepository<TaskEntity, Long> {


    List<TaskEntity> findByEmployeeEntity_Id(Long id);
}
