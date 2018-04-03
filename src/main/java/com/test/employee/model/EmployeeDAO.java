package com.test.employee.model;

import java.util.List;


//like additional DAO functions on top of repository
public interface EmployeeDAO {
    List<Employee> getAllEmployees();
}
