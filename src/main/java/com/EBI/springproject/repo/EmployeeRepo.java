package com.EBI.springproject.repo;

import com.EBI.springproject.model.Entity.EmployeeEntity;

public interface EmployeeRepo {

    public EmployeeEntity getEmployee( String id, String name, String salary);
}
