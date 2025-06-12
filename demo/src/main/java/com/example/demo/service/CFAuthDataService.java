package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CFAuthDataDto;

public interface CFAuthDataService {

	List<CFAuthDataDto> findAllByApplnoAndTradeDate(String applno, String tradeDateStr);

	void updateByApplno(String applno, List<CFAuthDataDto> dtoList);

}
