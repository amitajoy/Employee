package com.test.employee.impl;

import com.test.employee.EmployeeService;
import com.test.employee.model.Employee;
import com.test.employee.model.EmployeeResponse;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public EmployeeResponse getAllEmployees() {
        return null;
    }

    @Override
    public Employee getEmployee(String empId) {
        return null;
    }
}
