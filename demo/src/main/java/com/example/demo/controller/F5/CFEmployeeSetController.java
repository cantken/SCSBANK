package com.example.demo.controller.F5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CFEmployeeDto;
import com.example.demo.dto.CFMappingCodeYnDto;
import com.example.demo.dto.CFMappingGroupLevelDto;
import com.example.demo.dto.EmployeeGroupLevelDto;
import com.example.demo.dto.EmployeeRoleDto;
import com.example.demo.dto.RoleNoDto;
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

	@GetMapping("/EmployeeSet/query")
	@ResponseBody
	public Map<String, Object> getEmployeeSetDropdownData(
			@RequestParam(value = "empNo", required = false) String empNo) {
		Map<String, Object> data = new HashMap<>();

		// 查詢人員資料（如果有帶 empNo）
		List<CFEmployeeDto> employeeList = cFEmployeeService.findEmployeeWithRoleNo(empNo);
		data.put("employeeList", employeeList);

		// 下拉選單資料
		List<EmployeeGroupLevelDto> dropList1 = cFEmployeeService.findl2aEmpnoByGroupLevel();
		List<EmployeeGroupLevelDto> dropList2 = cFEmployeeService.findl2bEmpnoByGroupLevel();
		List<CFMappingGroupLevelDto> codeGroupLevelDropList = cFEmployeeService.findCodeNoAndCodeDescByGroupLevel();
		List<CFMappingCodeYnDto> codeYnDropList = cFEmployeeService.findCodeNoAndCodeDescByYn();

		data.put("dropList1", dropList1);
		data.put("dropList2", dropList2);
		data.put("codeGroupLevelDropList", codeGroupLevelDropList);
		data.put("codeYnDropList", codeYnDropList);

		return data;
	}

	@GetMapping("/EmployeeSet/roleDetail")
	@ResponseBody
	public Map<String, Object> employeeRoleDetail(@RequestParam("empNo") String empNo) {
		RoleNoDto roleNoDto = cFEmployeeRoleService.findEmpNoRoleNoByEmpNo(empNo);
		roleNoDto.setEmpNo(empNo);
		List<RoleNoDto> roleDtoList = cFRoleService.findRoleNoAndRoleName();

		Map<String, Object> result = new HashMap<>();
		result.put("roleNoDto", roleNoDto);
		result.put("roleDtoList", roleDtoList);

		return result; // Spring Boot 會自動轉成 JSON
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
