package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CFMappingCodeDropDownDto;
import com.example.demo.dto.CFMappingCodeDto;
import com.example.demo.dto.CardFlagDto;
import com.example.demo.dto.CardTypeDto;
import com.example.demo.dto.FraudTypeDto;
import com.example.demo.dto.YNDto;
import com.example.demo.entity.CFMappingCodeEntity;
import com.example.demo.repository.CFMappingCodeRepository;
import com.example.demo.service.CFMappingCodeService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade; // 正確的 Orika MapperFacade 導入

@Service
@RequiredArgsConstructor
public class CFMappingCodeServiceImpl implements CFMappingCodeService {

	private final CFMappingCodeRepository cFMappingCodeRepository;
	private final MapperFacade orika;

	// 系統代碼維護 下拉選單
	@Override
	public List<CFMappingCodeDropDownDto> findCodeNoDescByCodeType(String codeType) {
		if (codeType == null || codeType.isEmpty()) {
			codeType = "SYS_TYPE";
		}
		List<Map<String, Object>> cFMappingCodeMapList = cFMappingCodeRepository.findCodeNoDescByCodeType(codeType);
		List<CFMappingCodeDropDownDto> dropList = new ArrayList<>();

		for (Map<String, Object> map : cFMappingCodeMapList) {
			CFMappingCodeDropDownDto dto = new CFMappingCodeDropDownDto();
			// 假設您的 Map 中包含 "codeNo" 和 "codeDesc" 鍵，請根據實際情況調整鍵名
			dto.setCodeNo((String) map.get("codeNo"));
			dto.setCodeDesc((String) map.get("codeDesc"));
			dto.setCodeType(codeType);
			dropList.add(dto);
		}
		return dropList;
	}

	// 系統代碼維護 搜尋
	@Override
	public List<CFMappingCodeDto> findByCodeType(String codeType) {
		List<CFMappingCodeDto> dtoList = new ArrayList<>();
		List<CFMappingCodeEntity> cFMappingCodeList = cFMappingCodeRepository.findListByCodeType(codeType);
		dtoList = orika.mapAsList(cFMappingCodeList, CFMappingCodeDto.class);
		return dtoList; // 如果查詢沒有結果，會返回空的 List
	}

	// 系統代碼維護 新增
	@Transactional
	public void saveMappingCode(CFMappingCodeDto dto) {
		CFMappingCodeEntity entity = orika.map(dto, CFMappingCodeEntity.class);
		cFMappingCodeRepository.save(entity);
	}

	// 系統代碼維護 修改
	@Transactional
	public void updateMappingCode(CFMappingCodeDto dto) {
		String codeType = dto.getCodeType();
		String forRowid = dto.getForRowid();
		Map<String, Object> dbDto = cFMappingCodeRepository.findByForRowid(forRowid);
		if (dbDto == null) {
			throw new RuntimeException("找不到要更新的資料，codeType: " + codeType + ", rowid: " + forRowid);
		}

		// Map轉成Entity（不是Dto）
		CFMappingCodeEntity entity = new CFMappingCodeEntity();
		entity.setCodeType((String) dbDto.get("codeType"));
		entity.setCodeNo((String) dbDto.get("codeNo"));
		entity.setCodeDesc((String) dbDto.get("codeDesc"));
		entity.setCodeSort((Integer) dbDto.get("codeSort"));
		entity.setCodeTag((String) dbDto.get("codeTag"));
		entity.setCodeFlag((String) dbDto.get("codeFlag"));

		orika.map(dto, entity);
		cFMappingCodeRepository.save(entity);
	}

	// 卡片FLAG下拉
	@Override
	public List<CardFlagDto> findCardFlagByCodeType(String codeType) {
		return orika.mapAsList(cFMappingCodeRepository.findCardFlagByCodeType(codeType), CardFlagDto.class);
	}

	// 詐欺類型 下拉
	@Override
	public List<FraudTypeDto> findFraudTypeByCodeType(String codeType) {
		return orika.mapAsList(cFMappingCodeRepository.findFraudTypeByCodeType(codeType), FraudTypeDto.class);
	}

	// 卡別 下拉
	@Override
	public List<CardTypeDto> findCardTypeByCodeType(String codeType) {
		return orika.mapAsList(cFMappingCodeRepository.findCardTypeByCodeType(codeType), CardTypeDto.class);
	}

	// YN 下拉
	@Override
	public List<YNDto> findYNByCodeType(String codeType) {
		return orika.mapAsList(cFMappingCodeRepository.findYNByCodeType(codeType), YNDto.class);
	}

}
