package com.example.demo.service.Impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CFZipcodeDto;
import com.example.demo.repository.CFZipcoderRepository;
import com.example.demo.service.CFZipcoderService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CFZipcoderServiceImpl implements CFZipcoderService {

	@Autowired
	private final CFZipcoderRepository cFZipcoderRepository;
	//private final MapperFacade orika;

	@Autowired
	private ObjectMapper objectMapper;

	// 縣市下拉
	@Override
	public List<CFZipcodeDto> findZipNameByAllFkNo() {
		List<Map<String, Object>> list = cFZipcoderRepository.findZipNameByAllFkNo();
	    return list.stream()
	        .map(map -> objectMapper.convertValue(map, CFZipcodeDto.class))
	        .collect(Collectors.toList());
	}

	// 區下拉
	@Override
	public List<CFZipcodeDto> findZipNameByZipNo(String zipNo) {
		List<Map<String, Object>> list = cFZipcoderRepository.findZipNameByZipNo(zipNo);
	    return list.stream()
	        .map(map -> objectMapper.convertValue(map, CFZipcodeDto.class))
	        .collect(Collectors.toList());
	}

}
