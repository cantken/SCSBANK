package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CFAuthDataDto;
import com.example.demo.entity.CFAuthDataEntity;
import com.example.demo.repository.CFAuthDataRepository;
import com.example.demo.service.CFAuthDataService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CFAuthDataServiceImpl implements CFAuthDataService{

	@Autowired
	public CFAuthDataRepository cFAuthDataRepository;
	
	@Autowired
	private ObjectMapper objectMapper;

	
	// 找出所有資料
	@Override
	public List<CFAuthDataDto> findAllByApplnoAndTradeDate(String applno, String tradeDateStr) {
		List<Map<String, Object>> mapList = cFAuthDataRepository.findAllByApplNoAndTradeDate(applno, tradeDateStr);
		List<CFAuthDataDto> dtoList = new ArrayList<>();
		if (mapList == null || mapList.isEmpty()) {
			throw new IllegalArgumentException(" 查無此資料 ");
		} else {
	        dtoList = mapList.stream()
	                .map(map -> objectMapper.convertValue(map, CFAuthDataDto.class))
	                .collect(Collectors.toList());
		}
		return dtoList;
	}
	
	@Transactional
	public void updateByApplno(String applno, List<CFAuthDataDto> dtoList) {
	    System.out.println("收到更新 applno: " + applno);
	    System.out.println("收到更新 DTO List: " + dtoList);

	    // 根據 UUID 一筆一筆更新
	    for (CFAuthDataDto dto : dtoList) {
	        if (dto == null) continue;
	        String uuid = dto.getUuid();
	        if (uuid == null || uuid.isBlank()) continue;
	        uuid = uuid.trim();
	        System.out.println("處理 UUID: " + uuid);

	        List<CFAuthDataEntity> entityList = cFAuthDataRepository.findAllByUuid(uuid);

	        if (entityList.isEmpty()) {
	            System.out.println("查無 UUID 對應資料: " + uuid);
	            continue;
	        }

	        for(CFAuthDataEntity entity : entityList) {

	        System.out.println("更新前 choice: " + entity.getChoice());
	        System.out.println("DTO choice: " + dto.getChoice());

	        entity.setChoice(dto.getChoice());
	        entity.setTradeDate(dto.getTradeDateStr());
	        entity.setTradrTime(dto.getTradrTime());
	        entity.setAcBank(dto.getAcBank());
	        entity.setShopCode(dto.getShopCode());
	        entity.setMcc(dto.getMcc());
	        entity.setTradeCountry(dto.getTradeCountry());
	        entity.setTradeMoney(dto.getTradeMoney());
	        entity.setAuthCode(dto.getAuthCode());
	        entity.setEm(dto.getEm());
	        entity.setMfCode(dto.getMfCode());

	        cFAuthDataRepository.save(entity);
	        System.out.println("更新成功 UUID: " + uuid + ", choice 更新為: " + entity.getChoice());
	        }
	    }
	    cFAuthDataRepository.flush();
	}

}
