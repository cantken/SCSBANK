package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CFMappingCodeDropDownDto;
import com.example.demo.dto.CFMappingCodeDto;
import com.example.demo.entity.CFMappingCodeEntity;

public interface CFMappingCodeService {
	
	List<CFMappingCodeDto> findByCodeType(String codeType);

	List<CFMappingCodeDropDownDto> findCodeNoDescByCodeType(String codeType);

	void saveMappingCode(CFMappingCodeDto cFSystemCodeSetDto);
	
	void updateMappingCode(CFMappingCodeDto cFMappingCodeDto);

}

