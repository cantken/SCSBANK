package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.CFRoleFunctionEntity;
import com.example.demo.entity.RoleNoAndFnNoId;

public interface CFRoleFunctionRepository extends JpaRepository<CFRoleFunctionEntity, RoleNoAndFnNoId> {
	
	@Query(value = "SELECT a.FN_NO FROM CF_ROLE_FUNCTION a WHERE a.ROLE_NO = :roleNo", nativeQuery = true)
	List<Map<String, Object>> findFnNoByRoleNo(String roleNo);

	void deleteByRoleNo(String roleNo);

}
	