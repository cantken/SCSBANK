package com.example.demo.controller.F1;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.CFZipcodeDto;
import com.example.demo.dto.CardFlagDto;
import com.example.demo.dto.CardTypeDto;
import com.example.demo.dto.CfBatchParaDto;
import com.example.demo.dto.FraudTypeDto;
import com.example.demo.dto.YNDto;
import com.example.demo.service.CFMappingCodeService;
import com.example.demo.service.CFZipcoderService;
import com.example.demo.service.Impl.CFBatchParaService;

@Controller
public class CFCreateJobController {

	@Autowired
	private CFBatchParaService cFBatchParaService;
	private CFZipcoderService cFZipcoderService;
	private CFMappingCodeService cFMappingCodeService;

	// 一開始載入
	@GetMapping("/CreateJob")
	public String showCreateJobPage(@RequestParam(value = "para1") String para1,
									@RequestParam(value = "fkNo") String fkNo, 
									@RequestParam(value = "codeType") String codeType, 
									Model model
									) {
		if (StringUtils.isAllBlank(para1)) {
			para1 = "";
		}
		// 建檔作業收件編號
		CfBatchParaDto cfBatchParaDto = cFBatchParaService.findPara2(para1);
		model.addAttribute("cfBatchParaDto", cfBatchParaDto);

		// 建檔作業縣市下拉
		List<CFZipcodeDto> cityDtoList = cFZipcoderService.findZipNameByAllFkNo();
		model.addAttribute("cityDtoList", cityDtoList);

		// 建檔作業區下拉
		List<CFZipcodeDto> districtDtoList = cFZipcoderService.findZipNameByFkNo(fkNo);
		model.addAttribute("districtDtoList", districtDtoList);

		// 建檔作業卡片FLAG下拉
		List<CardFlagDto> cardFlagDtoList = cFMappingCodeService.findCardFlagByCodeType(codeType);
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

		return "CreateJob";
	}

}
