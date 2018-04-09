package com.test.greeting.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class GreetingResponse {
    private List<Greeting> greetingList = new ArrayList<>();
}
