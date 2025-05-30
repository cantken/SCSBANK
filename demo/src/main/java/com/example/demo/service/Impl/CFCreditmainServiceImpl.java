package com.example.demo.service.Impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CFCreditmainDto;
import com.example.demo.entity.CFCreditmainEntity;
import com.example.demo.repository.CFCreditmainRepository;
import com.example.demo.service.CFCreditmainService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CFCreditmainServiceImpl implements CFCreditmainService {
	
	@Autowired
	private final CFCreditmainRepository cFCreditmainRepository;
	private final ObjectMapper objectMapper;
	
	// 新建案件	
	@Override
	@Transactional
	public void saveCreditmain(CFCreditmainDto dto) {
		// 再寫一筆進 credit main
        CFCreditmainEntity entity = new CFCreditmainEntity();
        entity = objectMapper.convertValue(dto, CFCreditmainEntity.class);
        entity.setOpId("1020");
        entity.setCaseInputTime(LocalDateTime.now()); // 使用目前時間
        cFCreditmainRepository.save(entity);
	}

}
