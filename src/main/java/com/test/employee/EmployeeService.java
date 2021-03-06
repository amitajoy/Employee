package com.test.employee;

import com.test.employee.model.Employee;
import com.test.employee.model.EmployeeResponse;

public interface EmployeeService {
    EmployeeResponse getAllEmployees();
    Employee getEmployee(String empId);
    Employee addEmployee(String empId, String fname, String lname, int salary);
    void removeEmployee(String empId);
}
