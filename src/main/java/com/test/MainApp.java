package com.test;

import com.test.employee.model.Employee;

public class MainApp {
    public static void main(String[] args) {
        Employee e = new Employee("amit","agrawal",100);
        System.out.println(e.getFirstName());
        System.out.println(e);
    }
}
