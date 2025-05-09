package com.example.demo.service.Impl;

import java.util.List;

import com.example.demo.dto.CFZipcodeDto;
import com.example.demo.dto.CardFlagDto;
import com.example.demo.dto.CfBatchParaDto;

public interface CFBatchParaService2 {

	CfBatchParaDto findPara2(String para1);

	List<CFZipcodeDto> findZipNameByAllFkNo();

	List<CFZipcodeDto> findZipNameByFkNo(String fkNo);

	List<CardFlagDto> findCardFlagByCodeType(String codeType);

	List<CardFlagDto> findFraudTypeByCodeType(String codeType);

	List<CardFlagDto> findCardTypeByCodeType(String codeType);

	List<CardFlagDto> findYNByCodeType(String codeType);

}
