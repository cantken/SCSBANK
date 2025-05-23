package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CFMappingCodeServiceImpl implements CFMappingCodeService {

    private final CFMappingCodeRepository cFMappingCodeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    // 系統代碼維護 下拉選單
    @Override
    public List<CFMappingCodeDropDownDto> findCodeNoDescByCodeType(String codeType) {
        List<Map<String, Object>> cFMappingCodeMapList = cFMappingCodeRepository.findCodeNoDescByCodeType("SYS_TYPE");
        List<CFMappingCodeDropDownDto> dropList = new ArrayList<>();

        for (Map<String, Object> map : cFMappingCodeMapList) {
            CFMappingCodeDropDownDto dto = new CFMappingCodeDropDownDto();
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
        List<CFMappingCodeEntity> cFMappingCodeList = cFMappingCodeRepository.findListByCodeType(codeType);
        return cFMappingCodeList.stream()
                .map(entity -> objectMapper.convertValue(entity, CFMappingCodeDto.class))
                .collect(Collectors.toList());
    }

    // 系統代碼維護 新增
    @Transactional
    public void saveMappingCode(CFMappingCodeDto dto) {
        CFMappingCodeEntity entity = objectMapper.convertValue(dto, CFMappingCodeEntity.class);
        cFMappingCodeRepository.save(entity);
    }

    // 系統代碼維護 修改
    @Transactional
    public void updateMappingCode(CFMappingCodeDto dto) {
        String codeType = dto.getCodeType();
        String codeNo = dto.getCodeNo();
        CFMappingCodeEntity entity = cFMappingCodeRepository.findByCodeTypeAndCodeNo(codeType, codeNo);
        if (entity == null) {
            throw new RuntimeException("找不到要更新的資料，codeType: " + codeType + ", codeNo: " + codeNo);
        } 

        // 用 ObjectMapper 將 dto 欄位複寫到 entity 上
        try {
			objectMapper.updateValue(entity, dto);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		}
        cFMappingCodeRepository.save(entity);
    }

    // 卡片FLAG下拉
    @Override
    public List<CardFlagDto> findCardFlagByCodeType(String codeType) {
        List<Map<String, Object>> list = cFMappingCodeRepository.findCardFlagByCodeType(codeType);
        return list.stream()
                .map(map -> objectMapper.convertValue(map, CardFlagDto.class))
                .collect(Collectors.toList());
    }

    // 詐欺類型 下拉
    @Override
    public List<FraudTypeDto> findFraudTypeByCodeType(String codeType) {
        List<Map<String, Object>> list = cFMappingCodeRepository.findFraudTypeByCodeType(codeType);
        return list.stream()
                .map(map -> objectMapper.convertValue(map, FraudTypeDto.class))
                .collect(Collectors.toList());
    }

    // 卡別 下拉
    @Override
    public List<CardTypeDto> findCardTypeByCodeType(String codeType) {
        List<Map<String, Object>> list = cFMappingCodeRepository.findCardTypeByCodeType(codeType);
        return list.stream()
                .map(map -> objectMapper.convertValue(map, CardTypeDto.class))
                .collect(Collectors.toList());
    }

    // YN 下拉
    @Override
    public List<YNDto> findYNByCodeType(String codeType) {
    	 List<Map<String, Object>> list = cFMappingCodeRepository.findYNByCodeType(codeType); 	  
       
        return list.stream()
                .map(map -> objectMapper.convertValue(map, YNDto.class))
                .collect(Collectors.toList());     
    }
}
