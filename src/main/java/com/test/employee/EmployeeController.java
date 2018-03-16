package com.test.employee;

import com.test.employee.model.EmployeeResponse;
import javax.ws.rs.core.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    //TODO - add JPA and mongo
    //TODO - add  validation predicates
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<EmployeeResponse> getAllEmployees(){
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
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
