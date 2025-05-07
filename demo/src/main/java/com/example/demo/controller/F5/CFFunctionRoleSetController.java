package com.example.demo.controller.F5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.example.demo.Dto.CFRoleFunctionDto;
import com.example.demo.Dto.FunctionRoleSetDto;
import com.example.demo.Dto.RoleNoDto;
import com.example.demo.service.CFFunctionListService;
import com.example.demo.service.CFRoleFunctionService;
import com.example.demo.service.CFRoleService;

@Controller
public class CFFunctionRoleSetController {

	@Autowired
	private CFFunctionListService cFFunctionListService; // 注入 Service 的實作

	@Autowired
	private CFRoleService cFRoleService;

	@Autowired
	private CFRoleFunctionService cFRoleFunctionService;

	@GetMapping("/FunctionRoleSet")
	public String functionRoleSet(Model model) {

		// 查詢該組織明細
		List<FunctionRoleSetDto> functionRoleSetList = cFFunctionListService.findFunctionRoleSet();
		model.addAttribute("functionRoleSetList", functionRoleSetList);

		// 下拉角色
		List<RoleNoDto> roleNoDtoList = cFRoleService.findRoleNoAndRoleName();
		model.addAttribute("roleNoDtoList", roleNoDtoList);

		return "functionRoleSet";
	}

	@GetMapping(value = "/FunctionRoleSet/check", produces = "application/json")
	@ResponseBody
	public Map<String, Object> functionRoleSet(@RequestParam("roleNo") String roleNo) {
		Map<String, Object> result = new HashMap<>();

		List<CFRoleFunctionDto> cFRoleFunctionDtoList = cFRoleFunctionService.findFnNoByRoleNo(roleNo);
		List<FunctionRoleSetDto> functionRoleSetList = cFFunctionListService.findFunctionRoleSet();

		result.put("functionRoleSetList", functionRoleSetList);
		result.put("cFRoleFunctionDtoList", cFRoleFunctionDtoList);

		return result;
	}
	
	@PostMapping("/FunctionRoleSet/update")
	@ResponseBody
	public ResponseEntity<String> updateRoleFunctions(@RequestBody List<CFRoleFunctionDto> dtoList) {
		try {
			cFRoleFunctionService.updateRoleFunctions(dtoList);
			return ResponseEntity.ok("儲存成功");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("儲存失敗: " + e.getMessage());
		}
	}
}
