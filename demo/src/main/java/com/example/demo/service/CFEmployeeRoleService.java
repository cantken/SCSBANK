package com.example.demo.service;

import com.example.demo.Dto.EmployeeRoleDto;
import com.example.demo.Dto.RoleNoDto;

public interface CFEmployeeRoleService {
	
	RoleNoDto findEmpNoRoleNoByEmpNo(String empNo);

	void saveEmployeeRole(EmployeeRoleDto dto);
}
