package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FunctionRoleSetDto;
import com.example.demo.repository.CFFuctionListRepository;
import com.example.demo.service.CFFunctionListService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CFFunctionListServiceImpl implements CFFunctionListService {

	@Autowired
	private final CFFuctionListRepository cFFuctionListRepository;
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public List<FunctionRoleSetDto> findFunctionRoleSet() {
		List<Map<String, Object>> listMap = cFFuctionListRepository.findFunctionRoleSet();
		List<FunctionRoleSetDto> dtoList = new ArrayList<>();
		for (Map<String, Object> map : listMap) {
			FunctionRoleSetDto dto = objectMapper.convertValue(map, FunctionRoleSetDto.class); // 假設你已經設好 mapping
			dtoList.add(dto);
	    }
		return dtoList;
	}
}
