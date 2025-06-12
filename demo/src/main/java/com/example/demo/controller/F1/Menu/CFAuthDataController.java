package com.example.demo.controller.F1.Menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.CFAuthDataDto;
import com.example.demo.service.CFAuthDataService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class CFAuthDataController {

	@Autowired
	public CFAuthDataService cFAuthDataService;
	
	@Autowired
	ObjectMapper objectMapper = new ObjectMapper();
	// 授權頁籤帶入資料用
	@GetMapping("/AuthDataJson")
	@ResponseBody
	public Map<String, Object> getAuthData(@RequestParam(value = "applno", required = false) String applno,
			@RequestParam(value = "tradeDate", required = false) String tradeDateStr) {

		tradeDateStr = StringUtils.trimToNull(tradeDateStr);
		Map<String, Object> result = new HashMap<>();

		List<CFAuthDataDto> dtoList = cFAuthDataService.findAllByApplnoAndTradeDate(applno, tradeDateStr);
		result.put("dtoList", dtoList);

		return result;
	}


	// 更新授權頁籤資料
	
	@PostMapping("/AuthDataJson/update")
	@ResponseBody
	public Map<String, Object> updateAuthData(@RequestBody Map<String, Object> request) {
		try {
	        String applno = (String) request.get("applno");

	        @SuppressWarnings("unchecked")
	        List<Map<String, Object>> dtoListRaw = (List<Map<String, Object>>) request.get("dtoList");

	        // ✅ 顯式宣告 map 變數型別，避免推斷錯誤
	        List<CFAuthDataDto> dtoList = dtoListRaw.stream()
	            .map((Map<String, Object> map) -> objectMapper.convertValue(map, CFAuthDataDto.class))
	            .collect(Collectors.toList());

	        cFAuthDataService.updateByApplno(applno, dtoList);
	        
	        return Map.of("status", "success", "message", "更新成功");
		} catch (Exception e) {
			String msg = (e instanceof IllegalArgumentException) ? e.getMessage() : "更新失敗：" + e.getMessage();
			return Map.of("status", "error", "message", msg);
		}
	}

}
