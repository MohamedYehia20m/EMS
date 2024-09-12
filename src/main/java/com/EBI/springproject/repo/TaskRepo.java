package com.EBI.springproject.repo;

import com.EBI.springproject.Entity.EmployeeEntity;
import com.EBI.springproject.Entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<TaskEntity, Long> {


}
