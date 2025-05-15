package com.example.demo.controller.F2;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.CastListDto;
import com.example.demo.service.CFCaseinfoService;
import com.example.demo.service.CFEmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CFCaseListController {

	@Autowired
	private CFEmployeeService cFEmployeeService;
	@Autowired
	private CFCaseinfoService cFCaseinfoService;

	// 一開始載入
	@GetMapping("/CaseList")
	public String showCaseList(HttpSession session, Model model) {
		
		String empNo = (String) session.getAttribute("account");
		if (StringUtils.isBlank(empNo)) {
			throw new IllegalArgumentException("empNo 不得為空");
		}
		
		// 從findOpIdByEmpNo方法裡那道opId
		String opId = cFEmployeeService.findOpIdByEmpNo(empNo).getOpId();
		
		// 搜尋案件清單先將所有資料傳到前端後再由前端作條件判斷
		List<CastListDto> caseList = cFCaseinfoService.findCaseList(opId, empNo);
		model.addAttribute("caseList", caseList);

		return "CaseList";
	}

}
