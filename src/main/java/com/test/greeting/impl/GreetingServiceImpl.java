package com.test.greeting.impl;

import com.test.greeting.GreetingService;
import com.test.greeting.model.Greeting;
import com.test.greeting.model.GreetingResponse;
import com.test.greeting.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Inject
    private GreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(Greeting greeting) {
        return greetingRepository.save(greeting);
    }

    @Override
    public GreetingResponse listGreeting() {
        GreetingResponse gr = new GreetingResponse();
        List<Greeting> greetingList = greetingRepository.findAll();
        gr.setGreetingList(greetingList);

        return gr;
    }
}
