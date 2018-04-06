package com.test.employee.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"empId"})
@Document(collection = "EMPLOYEE")//mongo uses collection instead of tables
public class Employee{
    //Note: Mongo DB does not have auto sequence like RDBMS
    //@Table(name = "EMPLOYEE") -> mongo db has collection instead of tables
    private @Id
    String empId; //mongo id is string
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(String empId, String fname, String lname, int salary) {
        this.empId =empId;
        this.firstName = fname;
        this.lastName = lname;
        this.salary = salary;
    }
}
