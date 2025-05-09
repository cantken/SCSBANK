package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CFRoleFunctionDto;

public interface CFRoleFunctionService {
	
	List<CFRoleFunctionDto> findFnNoByRoleNo(String roleNo);

	void updateRoleFunctions(List<CFRoleFunctionDto> dtoList);

}
