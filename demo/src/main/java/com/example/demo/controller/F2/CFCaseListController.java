package com.example.demo.controller.F2;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.CFZipcodeDto;
import com.example.demo.dto.CardFlagDto;
import com.example.demo.dto.CardTypeDto;
import com.example.demo.dto.CastListDto;
import com.example.demo.dto.FraudTypeDto;
import com.example.demo.dto.YNDto;
import com.example.demo.service.CFBatchParaService;
import com.example.demo.service.CFCaseinfoService;
import com.example.demo.service.CFCreditmainService;
import com.example.demo.service.CFEmployeeService;
import com.example.demo.service.CFMappingCodeService;
import com.example.demo.service.CFPhaseService;
import com.example.demo.service.CFZipcoderService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpSession;

@Controller
public class CFCaseListController {

	@Autowired
	private CFEmployeeService cFEmployeeService;
	@Autowired
	private CFCaseinfoService cFCaseinfoService;
	@Autowired
	private CFBatchParaService cFBatchParaService;
	@Autowired
	private CFZipcoderService cFZipcoderService;
	@Autowired
	private CFMappingCodeService cFMappingCodeService;
	@Autowired
	private CFCreditmainService cFCreditmainService;
	@Autowired
	private CFPhaseService cFPhaseService;

	// 一開始載入
	@GetMapping("/CaseList")
	public String showCaseList(HttpSession session, Model model) throws Exception {
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
	
	
	// 按下取件按鈕
	@GetMapping("/Menu")
	public String showCaseListDetail(@Param("applno") String applno, HttpSession session, Model model) {
		
		String codeType = null;
		
		// 建檔作業縣市下拉
		List<CFZipcodeDto> cityDtoList = cFZipcoderService.findZipNameByAllFkNo();
		System.out.println("0000000000000000 cityDtoList = " + cityDtoList);
		model.addAttribute("cityDtoList", cityDtoList);

		// 建檔作業區下拉
		List<CFZipcodeDto> districtDtoList = cFZipcoderService.findZipNameByAllFkNo();
		model.addAttribute("districtDtoList", districtDtoList);

		// 建檔作業卡片FLAG下拉
		List<CardFlagDto> cardFlagDtoList = cFMappingCodeService.findCardFlagByCodeType(codeType);
		System.out.println("0000000000000000 cardFlagDtoList = " + cardFlagDtoList);
		model.addAttribute("cardFlagDtoList", cardFlagDtoList);

		// 建檔作業詐欺類型 下拉
		List<FraudTypeDto> fraudTypeDtoList = cFMappingCodeService.findFraudTypeByCodeType(codeType);
		model.addAttribute("fraudTypeDtoList", fraudTypeDtoList);

		// 建檔作業卡別 下拉
		List<CardTypeDto> cardTypeDtoList = cFMappingCodeService.findCardTypeByCodeType(codeType);
		model.addAttribute("cardTypeDtoList", cardTypeDtoList);

		// 建檔作業YN 下拉
		List<YNDto> yNDtoList = cFMappingCodeService.findYNByCodeType(codeType);
		model.addAttribute("yNDtoList", yNDtoList);

		return "Menu";
	}

}
