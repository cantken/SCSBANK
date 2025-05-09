package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CFZipcodeDto;
import com.example.demo.repository.CFZipcoderRepository;
import com.example.demo.service.CFZipcoderService;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;

@Service
@RequiredArgsConstructor
public class CFZipcoderServiceImpl implements CFZipcoderService {

	@Autowired
	private final CFZipcoderRepository cFZipcoderRepository;
	private final MapperFacade orika;

	// 縣市下拉
	@Override
	public List<CFZipcodeDto> findZipNameByAllFkNo() {
		return orika.mapAsList(cFZipcoderRepository.findZipNameByAllFkNo(), CFZipcodeDto.class);
	}

	// 區下拉
	@Override
	public List<CFZipcodeDto> findZipNameByFkNo(String fkNo) {
		return orika.mapAsList(cFZipcoderRepository.findZipNameByFkNo(fkNo), CFZipcodeDto.class);
	}

}
