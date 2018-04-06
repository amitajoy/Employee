package com.test.employee.impl;

import com.test.employee.EmployeeService;
import com.test.employee.model.Employee;
import com.test.employee.model.EmployeeResponse;
import com.test.employee.repository.EmployeeRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Inject
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponse getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setEmployees(employees);

        return employeeResponse;
    }

    @Override
    public Employee getEmployee(String empId) {
        Optional<Employee> opt = employeeRepository.findById(empId);
        return opt.get();
    }

    @Override
    public Employee addEmployee(String empId, String fname, String lname, int salary) {
       return employeeRepository.insert(new Employee(empId, fname,lname,salary));
    }

    @Override
    public void removeEmployee(String empId) {
        employeeRepository.deleteById(empId);
    }
}
