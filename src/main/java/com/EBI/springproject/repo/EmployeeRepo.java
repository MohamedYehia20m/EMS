package com.EBI.springproject.repo;

import com.EBI.springproject.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {


}
