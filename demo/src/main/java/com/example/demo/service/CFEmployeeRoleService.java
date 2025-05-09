package com.example.demo.service;

import com.example.demo.dto.EmployeeRoleDto;
import com.example.demo.dto.RoleNoDto;

public interface CFEmployeeRoleService {
	
	RoleNoDto findEmpNoRoleNoByEmpNo(String empNo);

	void saveEmployeeRole(EmployeeRoleDto dto);
}
