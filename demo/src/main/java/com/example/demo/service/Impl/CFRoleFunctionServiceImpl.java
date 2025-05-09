package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CFRoleFunctionDto;
import com.example.demo.entity.CFRoleFunctionEntity;
import com.example.demo.repository.CFRoleFunctionRepository;
import com.example.demo.service.CFRoleFunctionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;

@Service
@RequiredArgsConstructor
public class CFRoleFunctionServiceImpl implements CFRoleFunctionService {

	@Autowired
	CFRoleFunctionRepository cFRoleFunctionRepository;
	private final MapperFacade orika;

	@Override
	public List<CFRoleFunctionDto> findFnNoByRoleNo(String roleNo) {
		List<Map<String, Object>> mapList = cFRoleFunctionRepository.findFnNoByRoleNo(roleNo);
		return orika.mapAsList(mapList, CFRoleFunctionDto.class);
	}

	// 更新角色功能
	@Override
	@Transactional
	public void updateRoleFunctions(List<CFRoleFunctionDto> dtoList) {
		if (dtoList == null || dtoList.isEmpty()) {
			throw new IllegalArgumentException("輸入資料不得為空");
		}
		String roleNo = dtoList.get(0).getRoleNo();
		cFRoleFunctionRepository.deleteByRoleNo(roleNo);
		List<CFRoleFunctionEntity> entityList = orika.mapAsList(dtoList, CFRoleFunctionEntity.class);
		cFRoleFunctionRepository.saveAll(entityList);
	}
}