package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.CFRoleDto;
import com.example.demo.entity.CFRoleEntity;

@Repository
public interface CFRoleRepository extends JpaRepository<CFRoleEntity, String> {

	@Query(value = "SELECT r.ROLE_NO AS roleNo, r.ROLE_NAME AS roleName " + "FROM CF_ROLE r "
			+ "WHERE r.EMP_NO = :empNo", nativeQuery = true)
	List<Map<String, Object>> findRoleNoAndroleNameByempNo(@Param("empNo") String empNo);

	@Query(value = "SELECT r.ROLE_NO AS roleNo, " + "r.ROLE_NAME AS roleName, "
			+ "CASE WHEN er.EMP_NO IS NOT NULL THEN 1 ELSE 0 END AS selected " + "FROM CF_ROLE r "
			+ "LEFT JOIN CF_EMPLOYEE_ROLE er ON r.ROLE_NO = er.ROLE_NO AND er.EMP_NO = :empNo "
			+ "ORDER BY r.ROLE_NO", nativeQuery = true)
	List<Map<String, Object>> findRolesByEmpNo(@Param("empNo") String empNo);
	
}
