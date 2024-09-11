package com.EBI.springproject.repo;

import com.EBI.springproject.model.EmployeeDto;
import com.EBI.springproject.model.Entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public class EmployeeRepoImpl implements EmployeeRepo {

    @Autowired
    EmployeeDto employeeDto;

    @Override
    public EmployeeEntity getEmployee( String id, String name, String salary) {
        return new EmployeeEntity(id,  name, salary);
    }
}
