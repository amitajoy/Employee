package com.test.employee.repository;

import com.test.employee.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

//mongodb : no need to enable  JPA, no need of @Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
//    @Query(
//            value = "select * from (select lpd.* from lc$lp lp, lc$lpd lpd, lc$loan loan where lp.aid = ? and lpd.lp_id = lp.empId and lpd.status = 1 and loan.empId = lpd.loan_id and loan.status = 15 order by loan.status_d asc) where rownum < 2",
//            nativeQuery = true
//    )
//    List<LcLpd> findFirstRecentChargeOffByAid(Long var1);


}
