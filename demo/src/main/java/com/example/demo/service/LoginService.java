package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.dto.FunctionDto;
import com.example.demo.repository.CFEmployeeRepository;

@Service
public class LoginService {

	private final CFEmployeeRepository cFEmployeeRepository;

	public LoginService(CFEmployeeRepository cFEmployeeRepository) {
		this.cFEmployeeRepository = cFEmployeeRepository;
	}

	// 判斷使用者是否有登入許可
	public boolean hasLoginPermission(String account) {
		return cFEmployeeRepository.checkAccountExists(account) > 0;
	}

	// 查詢功能選單，依照群組分類
	public Map<String, List<FunctionDto>> getFunctionsByEmployee(String empNo) {
		List<Map<String, Object>> rawList = cFEmployeeRepository.showMenu(empNo);
		Map<String, List<FunctionDto>> result = new HashMap<>();
		
		for (Map<String, Object> row : rawList) {
			String codeDesc = (String) row.get("CODE_DESC"); // 功能群組名稱
			String fnPath = (String) row.get("FN_PATH");
			String fnDesc = (String) row.get("FN_DESC");

			FunctionDto dto = new FunctionDto();
			dto.setCodeDesc(codeDesc);
			dto.setFnPath(fnPath);
			dto.setFnDesc(fnDesc);

			result.computeIfAbsent(codeDesc, x -> new ArrayList<>()).add(dto);
		}
		return result;
	}
}
