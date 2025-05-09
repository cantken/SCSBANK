package com.example.demo.service.Impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CaseinfoDto;
import com.example.demo.repository.CFCaseinfoRepository;
import com.example.demo.service.CFCaseinfoService;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;

@Service
@RequiredArgsConstructor
public class CFCaseinfoServiceImpl implements CFCaseinfoService {

	@Autowired
	private final CFCaseinfoRepository cFCaseinfoRepository;
	private final MapperFacade orika;

	@Override
	public List<CaseinfoDto> findCaseInfo(String applno, String cuName, String cuId, String l3empno, Date caseInputTime) {
		List<Map<String, Object>> mapList = cFCaseinfoRepository.findCaseInfo(applno, cuName, cuId, l3empno, caseInputTime);
		List<CaseinfoDto> dtoList = new ArrayList<>();
		if (mapList == null || mapList.isEmpty()) {
			throw new IllegalArgumentException(" 查無此資料 ");
		} else {
			dtoList = orika.mapAsList(mapList, CaseinfoDto.class);
		}
		
		
		for (CaseinfoDto dto : dtoList) {
			if (caseInputTime != null) {
				dto.setCaseInputTimeStr(caseInputTime.toString()); // 傳 java.sql.Date，不要 toString()
			} else {
				dto.setCaseInputTimeStr(""); // 或 null，看你畫面需要什麼
			}
		}
		return dtoList;
	}
}
