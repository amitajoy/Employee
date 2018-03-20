package com.test.employee.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String>,EmployeeDAO {
//    @Query(
//            value = "select * from (select lpd.* from lc$lp lp, lc$lpd lpd, lc$loan loan where lp.aid = ? and lpd.lp_id = lp.id and lpd.status = 1 and loan.id = lpd.loan_id and loan.status = 15 order by loan.status_d asc) where rownum < 2",
//            nativeQuery = true
//    )
//    List<LcLpd> findFirstRecentChargeOffByAid(Long var1);



}
