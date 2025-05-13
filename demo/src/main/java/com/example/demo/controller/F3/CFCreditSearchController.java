package com.example.demo.controller.F3;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.CreditSearchDto;
import com.example.demo.service.CFCaseinfoService;

@Controller
public class CFCreditSearchController {

	@Autowired
	private CFCaseinfoService cFCaseinfoService;

	// 一開始載入
	@GetMapping("/CaseSearch")
	public String showCaseSearchPage(
			@RequestParam(value = "applno", required = false) String applno, 
			@RequestParam(value = "cuName", required = false) String cuName,
			@RequestParam(value = "cuId", required = false) String cuId,
			@RequestParam(value = "l3empno", required = false) String l3empno,
			@RequestParam(value = "caseInputTime", required = false) String caseInputTimeStr, Model model) {
	    // 畫面一開始載入空資料
		Date caseInputTime = null;
	    if (caseInputTimeStr != null && !caseInputTimeStr.trim().isEmpty()) {
	        try {
	        	caseInputTime = Date.valueOf(caseInputTimeStr); // 格式要是 yyyy-[m]m-[d]d
	        } catch (IllegalArgumentException e) {
	            // 可以加錯誤訊息顯示在畫面上
	            throw new RuntimeException("日期格式錯誤，應為 yyyy-MM-dd");
	        }
	    }
	    
		List<CreditSearchDto> caseinfoDtoList = cFCaseinfoService.findCaseInfo(applno, cuName, cuId, l3empno, caseInputTime);
	
		model.addAttribute("caseinfoDtoList",caseinfoDtoList);
	    return "CaseSearch"; 
	}
}
