package com.example.demo.service;

import java.util.List;

import com.example.demo.Dto.CFMappingCodeDto;
import com.example.demo.Dto.CFMappingCodeDropDownDto;
import com.example.demo.entity.CFMappingCodeEntity;

public interface CFMappingCodeService {
	
	List<CFMappingCodeDto> findByCodeType(String codeType);

	List<CFMappingCodeDropDownDto> findCodeNoDescByCodeType(String codeType);

	void saveMappingCode(CFMappingCodeDto cFSystemCodeSetDto);
	
	CFMappingCodeDto updateMappingCode(CFMappingCodeDto cFMappingCodeDto);

}

