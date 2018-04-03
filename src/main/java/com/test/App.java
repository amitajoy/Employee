package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//@Import(MongoSpringConfig.class)
@ComponentScan({"com.test.employee" , "com.test.employee.impl"})

public class App 
{
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
