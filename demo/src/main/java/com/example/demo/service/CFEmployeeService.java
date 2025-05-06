package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Lock;

import com.example.demo.Dto.CFEmployeeDto;
import com.example.demo.Dto.EmployeeGroupLevelDto;
import com.example.demo.Dto.CFMappingGroupLevelDto;
import com.example.demo.Dto.CFMappingCodeYnDto;

import jakarta.persistence.LockModeType;

public interface CFEmployeeService {

	List<CFEmployeeDto> findEmployeeWithRoleNo(String empNo);

	List<EmployeeGroupLevelDto> findl2aEmpnoByGroupLevel();

	List<EmployeeGroupLevelDto> findl2bEmpnoByGroupLevel();
	
	List<CFMappingGroupLevelDto> findCodeNoAndCodeDescByGroupLevel();

	List<CFMappingCodeYnDto> findCodeNoAndCodeDescByYn();
	
	void saveEmployee(CFEmployeeDto dto);

}
