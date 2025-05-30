package com.example.demo.controller.F5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.CFMappingCodeDropDownDto;
import com.example.demo.dto.CFMappingCodeDto;
import com.example.demo.entity.CFMappingCodeEntity;
import com.example.demo.service.CFMappingCodeService;

@Controller
public class CFMappingCodeController {

	@Autowired
	private CFMappingCodeService cfMappingCodeService; // 注入 Service 的實作

	// 系統代碼維護 搜尋
	@GetMapping("/MappingCode")
	public String MappingCode(@RequestParam(value = "codeType", required = false) String codeType, Model model) {
		List<CFMappingCodeDto> codeList = cfMappingCodeService.findByCodeType(codeType); // 使用注入的 Service 實例
		System.out.println("000000000000000000000000 codeList = " +  codeList);
		model.addAttribute("codeList", codeList); // 直接將 List<CFMappingCodeDto> 傳遞給前端

		// 下拉選單資料
		List<CFMappingCodeDropDownDto> dropList = cfMappingCodeService.findCodeNoDescByCodeType(codeType);
		model.addAttribute("dropList", dropList);
		return "MappingCode"; // 返回您的 Thymeleaf 模板名稱
	}

	// 系統代碼維護 新增
	@PostMapping("/MappingCode/save")
	public String save(@ModelAttribute CFMappingCodeDto dto, Model model) {
		cfMappingCodeService.saveMappingCode(dto);
		return "redirect:/MappingCode"; // 導到 resultPage.html
	}

	// 系統代碼維護 修改
	@PostMapping("/MappingCode/update")
	public String update(@ModelAttribute CFMappingCodeDto dto, Model model) {
		cfMappingCodeService.updateMappingCode(dto);
		return "redirect:/MappingCode"; // 導到 resultPage.html
	}


}
