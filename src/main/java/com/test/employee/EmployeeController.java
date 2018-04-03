package com.test.employee;

import com.test.employee.model.Employee;
import com.test.employee.model.EmployeeResponse;
import javax.ws.rs.core.MediaType;
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
@RequestMapping(value = "/employees")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
//@Api(value = "notes", description = "Note retrieval")
public class EmployeeController {
@Inject EmployeeService employeeService;

//http://localhost:8090/employees?firstName=Ajoy&lastName=Agrawal&salary=101
    //TODO - add JPA and mongo
    //TODO - add  validation predicates

    //get all employees
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<EmployeeResponse> getAllEmployees(){
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    //Get one employee
    @RequestMapping(value = "/{empId}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployee(@PathVariable("empId") String empId){
        return ResponseEntity.ok().body(employeeService.getEmployee(empId));
    }


    //remove one employee
    @RequestMapping(value = "/{empId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> removeEmployee(@PathVariable("empId") String empId){
        employeeService.removeEmployee(empId);
        return ResponseEntity.ok().build();
    }

    //add one employee
    @RequestMapping(value = "/{empId}", method = RequestMethod.POST)
    public ResponseEntity<Employee> addEmployee(@PathVariable("empId") String empId,
                                                @RequestParam("firstName") String firstName,
                                                @RequestParam("lastName") String lastName,
                                                @RequestParam("salary") String salary,
                                                @RequestHeader(required = false, value = "Accept") String mimeType){
        return ResponseEntity.ok().body(employeeService.addEmployee(empId, firstName,lastName,Integer.parseInt(salary)));
    }



//    @ApiOperation(value = "Returns a loan tape summary object", response = LoanTapeSummary.class)
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "Success", response = LoanTapeSummary.class),
//            @ApiResponse(code = 400, message = "Bad Request"),
//            @ApiResponse(code = 500, message = "Unexpected failure")})
//    @RequestMapping(value = "/loan-tape-summary", method = RequestMethod.GET)
//    public ResponseEntity<LoanTapeSummary> getLoanTapeSummary(@Valid LoanTapeRequestParamModel model) {
//        validateLoanTapeRequestParamModel(model);
//        return ResponseEntity.ok().body(notesService.getLoanTapeSummary(model.getActorIds(), model.getLoanIds(), model.getOrderIds(), model.getNoteIds()));
//    }
}
