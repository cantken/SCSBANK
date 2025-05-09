package com.example.demo.service;

import java.sql.Date;
import java.util.List;

import com.example.demo.dto.CaseinfoDto;

public interface CFCaseinfoService {

	List<CaseinfoDto> findCaseInfo(String applNo, String cuName, String cuId, String l3EmpNo, Date caseInputTime);

}
