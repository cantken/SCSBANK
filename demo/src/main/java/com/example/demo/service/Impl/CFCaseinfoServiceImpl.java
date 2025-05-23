package com.example.demo.service.Impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.juli.JsonFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CaseinfoDto;
import com.example.demo.dto.CastListDto;
import com.example.demo.dto.CreditSearchDto;
import com.example.demo.entity.CFCaseinfoEntity;
import com.example.demo.repository.CFCaseinfoRepository;
import com.example.demo.service.CFCaseinfoService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CFCaseinfoServiceImpl implements CFCaseinfoService {

	@Autowired
	private CFCaseinfoRepository cFCaseinfoRepository;
	private final ObjectMapper objectMapper;

	@Override
	public List<CreditSearchDto> findCaseInfo(String applno, String cuName, String cuId, String l3empno, Date caseInputTime) {
		List<Map<String, Object>> mapList = cFCaseinfoRepository.findCaseInfo(applno, cuName, cuId, l3empno, caseInputTime);
		List<CreditSearchDto> dtoList = new ArrayList<>();
		if (mapList == null || mapList.isEmpty()) {
			throw new IllegalArgumentException(" 查無此資料 ");
		} else {

	        dtoList = mapList.stream()
	                .map(map -> objectMapper.convertValue(map, CreditSearchDto.class))
	                .collect(Collectors.toList());
		}
		
		for (CreditSearchDto dto : dtoList) {
			if (caseInputTime != null) {
				dto.setCaseInputTimeStr(caseInputTime.toString()); // 傳 java.sql.Date，不要 toString()
			} else {
				dto.setCaseInputTimeStr(""); // 或 null，看你畫面需要什麼
			}
		}
		return dtoList;
	}

	// 新建案件存檔
	@Override
	public void save(CaseinfoDto dto) {
		    CFCaseinfoEntity entity = new CFCaseinfoEntity();
		    entity = objectMapper.convertValue(dto, CFCaseinfoEntity.class);
		    cFCaseinfoRepository.save(entity); // 存到 DB
	}
	
	// 搜尋案件清單
	@Override
	public List<CastListDto> findCaseList(String opId, String empNo) {
		List<Map<String, Object>> mapList = cFCaseinfoRepository.findCaseList(opId, empNo);
		System.out.println("mapList.size() :"+ mapList.size());
		List<CastListDto> dtoList = mapList.stream()
        .map(map -> objectMapper.convertValue(map, CastListDto.class))
        .collect(Collectors.toList());
		System.out.println("00000000000000000000000000000 dtoList = " + dtoList );
		return dtoList;
	}
}
