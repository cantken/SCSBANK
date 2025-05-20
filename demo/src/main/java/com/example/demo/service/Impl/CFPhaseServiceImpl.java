package com.example.demo.service.Impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CFPhaseDto;
import com.example.demo.entity.CFPhaseEntity;
import com.example.demo.repository.CFPhaseRepository;
import com.example.demo.service.CFPhaseService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CFPhaseServiceImpl implements CFPhaseService {
	
	@Autowired
	private CFPhaseRepository cFPhaseRepository;
	private final ObjectMapper objectMapper;
	
	// 新建案件
	@Override
	@Transactional
	public void savePhase(CFPhaseDto dto) {
		
		CFPhaseEntity entity1000 = new CFPhaseEntity();
		entity1000 = objectMapper.convertValue(dto, CFPhaseEntity.class);
		entity1000.setOpId("1000");
		entity1000.setStatusId("S");
		entity1000.setStartDate(LocalDateTime.now());
		entity1000.setEndDate(LocalDateTime.now());
		System.out.println("000000000000000000 entity1000 = " + entity1000);
		cFPhaseRepository.save(entity1000);
		
		CFPhaseEntity entity1020 = new CFPhaseEntity();
		entity1020 = objectMapper.convertValue(dto, CFPhaseEntity.class);
		entity1020.setOpId("1020");
		entity1020.setStartDate(LocalDateTime.now());
		System.out.println("000000000000000000 entity1020 = " + entity1020);
		cFPhaseRepository.save(entity1020);
		
	}
}
