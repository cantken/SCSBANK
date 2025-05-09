package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CFMappingCodeDropDownDto;
import com.example.demo.dto.CFMappingCodeDto;
import com.example.demo.dto.CardFlagDto;
import com.example.demo.dto.CardTypeDto;
import com.example.demo.dto.FraudTypeDto;
import com.example.demo.dto.YNDto;
import com.example.demo.entity.CFMappingCodeEntity;

public interface CFMappingCodeService {
	
	List<CFMappingCodeDto> findByCodeType(String codeType);

	List<CFMappingCodeDropDownDto> findCodeNoDescByCodeType(String codeType);

	void saveMappingCode(CFMappingCodeDto cFSystemCodeSetDto);
	
	void updateMappingCode(CFMappingCodeDto cFMappingCodeDto);

	List<CardFlagDto> findCardFlagByCodeType(String codeType);

	List<FraudTypeDto> findFraudTypeByCodeType(String codeType);

	List<CardTypeDto> findCardTypeByCodeType(String codeType);

	List<YNDto> findYNByCodeType(String codeType);

}

