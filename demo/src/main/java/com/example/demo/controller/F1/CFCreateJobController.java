package com.example.demo.controller.F1;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.CFCreditmainDto;
import com.example.demo.dto.CFPhaseDto;
import com.example.demo.dto.CFZipcodeDto;
import com.example.demo.dto.CardFlagDto;
import com.example.demo.dto.CardTypeDto;
import com.example.demo.dto.CaseinfoDto;
import com.example.demo.dto.CfBatchParaDto;
import com.example.demo.dto.FraudTypeDto;
import com.example.demo.dto.YNDto;
import com.example.demo.service.CFBatchParaService;
import com.example.demo.service.CFCaseinfoService;
import com.example.demo.service.CFCreditmainService;
import com.example.demo.service.CFMappingCodeService;
import com.example.demo.service.CFPhaseService;
import com.example.demo.service.CFZipcoderService;


@Controller
public class CFCreateJobController {

	@Autowired
	private CFBatchParaService cFBatchParaService;
	@Autowired
	private CFZipcoderService cFZipcoderService;
	@Autowired
	private CFMappingCodeService cFMappingCodeService;
	@Autowired
	private CFCaseinfoService cFCaseinfoService;
	@Autowired
	private CFCreditmainService cFCreditmainService;
	@Autowired
	private CFPhaseService cFPhaseService;

	// 一開始載入
	@GetMapping("/CreateJob")
	public String showCreateJobPage(@RequestParam(value = "para1", required = false) String para1,
									@RequestParam(value = "fkNo", required = false) String fkNo, 
									@RequestParam(value = "codeType", required = false) String codeType, 
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
		List<CFZipcodeDto> districtDtoList = cFZipcoderService.findZipNameByAllFkNo();
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
	
	// 建檔作業區下拉
	@GetMapping("/getDistricts")
	@ResponseBody
	public List<CFZipcodeDto> getDistricts(@RequestParam("zipNo") String zipNo) {
	    List<CFZipcodeDto> districtDtoList = cFZipcoderService.findZipNameByZipNo(zipNo);
	    return districtDtoList ;
	}
	
	// 建檔作業新增
	@PostMapping("/CreateJob/save")
	@ResponseBody
	public ResponseEntity<String> saveCaseinfo(@RequestBody CaseinfoDto dto) {
		try {
			
		    // 存儲前端頁面資料進到db
			cFCaseinfoService.save(dto);
			
			// 再寫一筆進 credit main
			CFCreditmainDto creditmainDto = new CFCreditmainDto();
			creditmainDto.setApplno(dto.getApplno());
			cFCreditmainService.saveCreditmain(creditmainDto);
	        
			// 再寫一筆進 CFPhase
			CFPhaseDto cFPhaseDto = new CFPhaseDto();
			cFPhaseDto.setApplno(dto.getApplno());
	        cFPhaseService.savePhase(cFPhaseDto);
	        
			return ResponseEntity.ok("儲存成功");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("儲存失敗: " + e.getMessage());
		}

	}
}
