package com.example.demo.service.Impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeRoleDto;
import com.example.demo.dto.RoleNoDto;
import com.example.demo.entity.CFEmployeeRoleEntity;
import com.example.demo.repository.CFEmployeeRoleRepository;
import com.example.demo.service.CFEmployeeRoleService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;

@Service
@RequiredArgsConstructor
public class CFEmployeeRoleServiceImpl implements CFEmployeeRoleService {

	@Autowired
	private final CFEmployeeRoleRepository cFEmployeeRoleRepository;
	private final MapperFacade orika;

	@Override
	public RoleNoDto findEmpNoRoleNoByEmpNo(String empNo) {
		Map<String, Object> map = cFEmployeeRoleRepository.findRoleNoByEmpNo(empNo);
		RoleNoDto dto = new RoleNoDto();
		if (map == null || map.isEmpty()) {
			return null;
		} else {
			dto.setRoleNo((String) map.get("roleNo"));
		}
		return dto;
	}

	@Override
	@Transactional
	public void saveEmployeeRole(EmployeeRoleDto dto) {
		String empNo = dto.getEmpNo();
	    CFEmployeeRoleEntity dbEntity = cFEmployeeRoleRepository.findByEmpNo(empNo);
	    CFEmployeeRoleEntity entity = new CFEmployeeRoleEntity();
	    entity.setRoleNo(dto.getRoleNo());
	    entity.setEmpNo(dto.getEmpNo());
	    cFEmployeeRoleRepository.delete(dbEntity);
	    cFEmployeeRoleRepository.save(entity);
	}
}
