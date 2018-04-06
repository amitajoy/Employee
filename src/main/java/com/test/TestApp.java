package com.test;

import com.test.employee.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class TestApp {
    public static void main(String[] args) {
//        Employee e = new Employee("amit","agrawal",100);
//        System.out.println(e.getFirstName());
//        System.out.println(e);

        List<String> propNames = Arrays.asList("MONGO_URI","MONGO_USERNAME","MONGO_PASSWORD");
        Properties properties = System.getProperties();
        propNames.stream()
                .map(propName -> properties.getProperty(propName))
                .forEach(System.out::println);




    }
}
