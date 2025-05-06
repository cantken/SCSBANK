package com.example.demo.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CFEmployeeRoleEntity;
import com.example.demo.entity.CFEmployeeRoleId;

public interface CFEmployeeRoleRepository extends JpaRepository<CFEmployeeRoleEntity, CFEmployeeRoleId> {

	@Query(value = "SELECT a.ROLE_NO AS roleNo FROM CF_EMPLOYEE_ROLE a WHERE a.EMP_NO = :empNo", nativeQuery = true)
	Map<String, Object> findRoleNoByEmpNo(@Param("empNo") String empNo);

	CFEmployeeRoleEntity findByEmpNo(String empNo);

}	
