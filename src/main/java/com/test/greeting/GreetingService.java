package com.test.greeting;

import com.test.greeting.model.Greeting;
import com.test.greeting.model.GreetingResponse;

public interface GreetingService {
    Greeting addGreeting(Greeting greeting);

    GreetingResponse listGreeting();
}
