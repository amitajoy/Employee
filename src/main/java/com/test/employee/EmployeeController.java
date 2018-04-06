package com.test.employee;

import com.test.employee.model.Employee;
import com.test.employee.model.EmployeeResponse;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

@RestController
@RequestMapping(value = EmployeeController.EMPLOYEES_RESOURCE)
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Api(value = "Employees", description = "operations on Employees")
public class EmployeeController {
    public static final String EMPLOYEES_RESOURCE = "/employees";
    @Inject EmployeeService employeeService;

    //http://localhost:8090/employees?firstName=Ajoy&lastName=Agrawal&salary=101
    //TODO - add  validation predicates

    @ApiOperation(value = "List of Employees", response = EmployeeResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

            @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<EmployeeResponse> getAllEmployees(){
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @ApiOperation(value = "Get one employee", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(value = "/{empId}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployee(@PathVariable("empId") String empId){
        return ResponseEntity.ok().body(employeeService.getEmployee(empId));
    }


    @ApiOperation(value = "remove one employee", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(value = "/{empId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> removeEmployee(@PathVariable("empId") String empId){
        employeeService.removeEmployee(empId);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "add one employee", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @RequestMapping(value = "/{empId}", method = RequestMethod.POST)
    public ResponseEntity<Employee> addEmployee(@PathVariable("empId") String empId,
                                                @RequestParam("firstName") String firstName,
                                                @RequestParam("lastName") String lastName,
                                                @RequestParam("salary") String salary,
                                                @RequestHeader(required = false, value = "Accept") String mimeType){
        return ResponseEntity.ok().body(employeeService.addEmployee(empId, firstName,lastName,Integer.parseInt(salary)));
    }

}
