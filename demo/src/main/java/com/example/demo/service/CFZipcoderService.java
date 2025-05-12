package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CFZipcodeDto;

public interface CFZipcoderService {

	List<CFZipcodeDto> findZipNameByAllFkNo();

	List<CFZipcodeDto> findZipNameByZipNo(String zipNo);

}
