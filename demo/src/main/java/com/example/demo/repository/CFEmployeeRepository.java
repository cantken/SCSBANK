package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CFEmployeeEntity;

public interface CFEmployeeRepository extends JpaRepository<CFEmployeeEntity, String> {
	
	@Query(value = "SELECT COUNT(*) FROM CF_EMPLOYEE A, CF_EMPLOYEE_ROLE B WHERE A.EMP_NO = B.EMP_NO AND A.ON_JOB = 'Y' AND A.EMP_NO =:empNo", nativeQuery = true)
    Integer checkAccountExists(String empNo);
	
	@Query(value = """
	        SELECT E.CODE_DESC, 
	               D.FN_PATH, 
	               D.FN_DESC 
	        FROM  CF_EMPLOYEE A
	              JOIN CF_EMPLOYEE_ROLE B ON A.EMP_NO = B.EMP_NO
	              JOIN CF_ROLE_FUNCTION C ON B.ROLE_NO = C.ROLE_NO
	              JOIN CF_FUNCTION_LIST D ON C.FN_NO = D.FN_NO
	              JOIN CF_MAPPING_CODE E ON D.FN_GROUP_NO = E.CODE_NO
	        WHERE E.CODE_TYPE = 'FN_GROUP'
	          AND A.EMP_NO = :empNo
	        ORDER BY E.CODE_SORT, D.FN_SORT
	        """, nativeQuery = true)
	    List<Map<String, Object>> showMenu(@Param("empNo") String empNo);
	

	
	
}



