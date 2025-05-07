package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.CFRoleFunctionDto;
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
		List<CFRoleFunctionEntity> entityList = new ArrayList<>();
		for (CFRoleFunctionDto dto : dtoList) {
			String roleNo = dto.getRoleNo(); // 前端進來的roleNo值必定只有一種
			List<Map<String, Object>> mapList = cFRoleFunctionRepository.findFnNoByRoleNo(roleNo);
			if (mapList == null || mapList.isEmpty()) {				
				List<CFRoleFunctionEntity> dbEntityList = orika.mapAsList(mapList, CFRoleFunctionEntity.class);
				entityList.addAll(dbEntityList);
			}else {
			}
			cFRoleFunctionRepository.saveAll(entityList);
		}
	}


}