package com.test.greeting;

import com.test.greeting.model.Greeting;
import com.test.greeting.model.GreetingResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping(value = GreetingController.GREETING_RESOURCE)
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Api(value = "Greeting", description = "simple greeting")
public class GreetingController {
    @Inject
    private GreetingService greetingService;
    private static final String template = "Hello, %s!";
    public static final String GREETING_RESOURCE = "/greeting";


    @ApiOperation(value = "List of Greetings", response = GreetingResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<GreetingResponse> getAllGreetings(){
        return ResponseEntity.ok().body(greetingService.listGreeting());
    }

    @ApiOperation(value = "Add greeting", response = Greeting.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(method = RequestMethod.POST)
    public Greeting addGreeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(String.format(template, name));
    }

}
