package com.example.demo.service.Impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CFRoleFunctionDto;
import com.example.demo.entity.CFRoleFunctionEntity;
import com.example.demo.repository.CFRoleFunctionRepository;
import com.example.demo.service.CFRoleFunctionService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CFRoleFunctionServiceImpl implements CFRoleFunctionService {

	@Autowired
	CFRoleFunctionRepository cFRoleFunctionRepository;
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public List<CFRoleFunctionDto> findFnNoByRoleNo(String roleNo) {
		List<Map<String, Object>> mapList = cFRoleFunctionRepository.findFnNoByRoleNo(roleNo);
		return mapList.stream()
				.map(map-> objectMapper.convertValue(map, CFRoleFunctionDto.class))
				.collect(Collectors.toList());
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
		List<CFRoleFunctionEntity> entityList = dtoList.stream()
				.map(dto -> objectMapper.convertValue(dto, CFRoleFunctionEntity.class))
				.collect(Collectors.toList());
		cFRoleFunctionRepository.saveAll(entityList);
	}
}