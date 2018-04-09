package com.test.greeting.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@ToString
@Getter

//Using a RDBMS
@Entity(name="GREETING")
public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String content;

    public Greeting(String content) {
        this.content = content;
    }

}
