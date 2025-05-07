package com.example.demo.controller.F5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Dto.CFEmployeeDto;
import com.example.demo.Dto.CFMappingCodeYnDto;
import com.example.demo.Dto.CFMappingGroupLevelDto;
import com.example.demo.Dto.CFRoleDto;
import com.example.demo.Dto.EmployeeGroupLevelDto;
import com.example.demo.Dto.EmployeeRoleDto;
import com.example.demo.Dto.RoleNoDto;
import com.example.demo.service.CFEmployeeRoleService;
import com.example.demo.service.CFEmployeeService;
import com.example.demo.service.CFRoleService;

@Controller
public class CFEmployeeSetController {

	@Autowired
	private CFEmployeeService cFEmployeeService; // 注入 Service 的實作

	@Autowired
	private CFRoleService cFRoleService;

	@Autowired
	private CFEmployeeRoleService cFEmployeeRoleService;

	// 👉 一開始進入頁面：不查資料
	@GetMapping("/EmployeeSet")
	public String showPageWithoutData() {
		return "EmployeeSet"; // 回傳 Thymeleaf 畫面，不附帶任何資料
	}

	// 組織人員維護 搜尋
	@GetMapping("/EmployeeSet/query")
	public String employeeSetQuery(@RequestParam(value = "empNo", required = false) String empNo, Model model) {

		List<CFEmployeeDto> employeeList = cFEmployeeService.findEmployeeWithRoleNo(empNo);
		model.addAttribute("employeeList", employeeList);

		// 組織人員維護 下拉覆審A送件主管
		List<EmployeeGroupLevelDto> dropList1 = cFEmployeeService.findl2aEmpnoByGroupLevel();
		model.addAttribute("dropList1", dropList1);

		// 組織人員維護 下拉覆審B送件主管
		List<EmployeeGroupLevelDto> dropList2 = cFEmployeeService.findl2bEmpnoByGroupLevel();
		model.addAttribute("dropList2", dropList2);

		// 組織人員維護 派件層級
		List<CFMappingGroupLevelDto> codeGroupLevelDropList = cFEmployeeService.findCodeNoAndCodeDescByGroupLevel();
		model.addAttribute("codeGroupLevelDropList", codeGroupLevelDropList);

		// 組織人員維護 是否在職
		List<CFMappingCodeYnDto> codeYnDropList = cFEmployeeService.findCodeNoAndCodeDescByYn();
		model.addAttribute("codeYnDropList", codeYnDropList);

		return "EmployeeSet";
	}

	@GetMapping("/EmployeeSet/roleDetail")
	public String employeeRoleDetail(@RequestParam("empNo") String empNo, Model model) {

		// 查詢該員工角色明細
		RoleNoDto roleNoDto = cFEmployeeRoleService.findEmpNoRoleNoByEmpNo(empNo);
		roleNoDto.setEmpNo(empNo);
		model.addAttribute("roleNoDto", roleNoDto);

		// 其他彈窗可能需要的資料也可加上，例如角色選單等等
		List<RoleNoDto> roleDtoList = cFRoleService.findRoleNoAndRoleName();
		model.addAttribute("roleDtoList", roleDtoList);

		return "EmployeeSetRoleDetailModal :: modalContent"; // 指向彈窗的 template/view
	}

	@PostMapping("/EmployeeSet/save")
	@ResponseBody
	public ResponseEntity<String> save(@ModelAttribute CFEmployeeDto dto) {
		try {
			cFEmployeeService.saveEmployee(dto);
			return ResponseEntity.ok("儲存成功");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("儲存失敗: " + e.getMessage());
		}
	}

	@PostMapping("/EmployeeSet/role/save")
	@ResponseBody
	public ResponseEntity<String> saveRole(@ModelAttribute EmployeeRoleDto dto) {
		try {
			cFEmployeeRoleService.saveEmployeeRole(dto);
			return ResponseEntity.ok("角色儲存成功");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("角色儲存失敗: " + e.getMessage());
		}
	}

}
