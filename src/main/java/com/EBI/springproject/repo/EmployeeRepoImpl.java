package com.EBI.springproject.repo;

import com.EBI.springproject.model.EmployeeDto;
import com.EBI.springproject.model.Entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepoImpl implements EmployeeRepo {

    public List<EmployeeEntity> getAllEmployees() {
        List<EmployeeEntity> employees = new ArrayList<EmployeeEntity>();
        EmployeeEntity employee = new EmployeeEntity("1","Mohamed","10000");
        EmployeeEntity employee2 = new EmployeeEntity("2","Moaaz","700");
        employees.add(employee);
        employees.add(employee2);

        return employees;
    }

    public EmployeeEntity getEmployeeById(Long id) {
        EmployeeEntity employee = new EmployeeEntity(String.valueOf(id) ,"Mohamed","10000");
        return employee;
    }

    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        return employeeEntity;
    }

    public EmployeeEntity patchUpdateEmployee(EmployeeEntity employeeEntity, Long id) {
        return employeeEntity;
    }

    public EmployeeEntity UpdateEmployee(EmployeeEntity employeeEntity, Long id) {
        return employeeEntity;
    }

    public Boolean deleteEmployee(Long id) {
        return true;
    }
}
