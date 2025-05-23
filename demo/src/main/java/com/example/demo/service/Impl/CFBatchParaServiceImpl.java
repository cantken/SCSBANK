package com.example.demo.service.Impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CfBatchParaDto;
import com.example.demo.repository.CFBatchParaRepository;
import com.example.demo.service.CFBatchParaService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;

@Service
@RequiredArgsConstructor
public class CFBatchParaServiceImpl implements CFBatchParaService {

	@Autowired
	private final CFBatchParaRepository cFBatchParaRepository;
	
//	private final MapperFacade orika;
	
	@Autowired
	private ObjectMapper objectMapper;

	// 帶入收件編號
	@Override
	public CfBatchParaDto findPara2(String para1) {
		if (StringUtils.isBlank(para1)) {
			String datePart = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
			Integer currentSerial = cFBatchParaRepository.findCurrentSerial(datePart);
			int nextSerial = (currentSerial != null) ? currentSerial + 1 : 1;

			// 補0成3位數，例如 001、023
			String serialStr = String.format("%03d", nextSerial);

			// 組合 para1：20250509A001
			para1 = datePart + "A" + serialStr;
		}
		Map<String, Object> map = cFBatchParaRepository.findPara2(para1);
		CfBatchParaDto dto = objectMapper.convertValue(map, CfBatchParaDto.class);
		return dto;
	}

}
