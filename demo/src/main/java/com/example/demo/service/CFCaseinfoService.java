package com.example.demo.service;

import java.sql.Date;
import java.util.List;

import com.example.demo.dto.CaseinfoDto;
import com.example.demo.dto.CreditSearchDto;

public interface CFCaseinfoService {

	List<CreditSearchDto> findCaseInfo(String applNo, String cuName, String cuId, String l3EmpNo, Date caseInputTime);

	void save(CaseinfoDto dto);

}
