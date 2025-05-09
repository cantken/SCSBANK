package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CFRoleDto;
import com.example.demo.dto.RoleNoDto;
import com.example.demo.entity.CFRoleEntity;
import com.example.demo.repository.CFEmployeeRoleRepository;
import com.example.demo.repository.CFRoleRepository;
import com.example.demo.service.CFRoleService;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;

@Service
@RequiredArgsConstructor
public class CFRoleServiceImpl implements CFRoleService {

	@Autowired
	CFEmployeeRoleRepository cFEmployeeRoleRepository;

	@Autowired
	CFRoleRepository cFRoleRepository;
	private final MapperFacade orika;

	@Override
	public List<RoleNoDto> findRoleNoAndRoleName() {

		List<CFRoleEntity> roleEntityList = cFRoleRepository.findAll();
		List<CFRoleDto> dbroleDtoList = orika.mapAsList(roleEntityList, CFRoleDto.class);
		List<RoleNoDto> roleDtoList = new ArrayList<>();
		
		for(CFRoleDto dbdto : dbroleDtoList) {
			RoleNoDto dto = new RoleNoDto();
			dto.setRoleNo(dbdto.getRoleNo());
			dto.setRoleName(dbdto.getRoleName());
			roleDtoList.add(dto);
		}
		return roleDtoList;
	}
	
	@Override
	public List<CFRoleDto> findAllRoles() {
		List<CFRoleEntity> roleEntityList = cFRoleRepository.findAll();
		return orika.mapAsList(roleEntityList, CFRoleDto.class);
	}
}
