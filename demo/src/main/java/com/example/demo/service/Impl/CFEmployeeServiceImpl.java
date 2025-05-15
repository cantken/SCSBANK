package com.example.demo.service.Impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CFEmployeeDto;
import com.example.demo.dto.CFMappingCodeYnDto;
import com.example.demo.dto.CFMappingGroupLevelDto;
import com.example.demo.dto.EmployeeGroupLevelDto;
import com.example.demo.dto.OpIdDto;
import com.example.demo.entity.CFEmployeeEntity;
import com.example.demo.repository.CFEmployeeRepository;
import com.example.demo.service.CFEmployeeService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;

@Service
@RequiredArgsConstructor
public class CFEmployeeServiceImpl implements CFEmployeeService {

	@Autowired
	private final CFEmployeeRepository cFEmployeeRepository;
	private final MapperFacade orika;

	// 組織人員維護 搜尋
	@Override
	public List<CFEmployeeDto> findEmployeeWithRoleNo(String empNo) {
		List<Map<String, Object>> cFEmployeeMapList = cFEmployeeRepository.findEmployeeWithRoleNo(empNo);
		List<CFEmployeeDto> dtoList = orika.mapAsList(cFEmployeeMapList, CFEmployeeDto.class);
		return dtoList; // 如果查詢沒有結果，會返回空的 List
	}

	// 組織人員維護 下拉l2a Empno
	@Override
	public List<EmployeeGroupLevelDto> findl2aEmpnoByGroupLevel() {
		List<Map<String, Object>> l2aEmpnoMapList = cFEmployeeRepository.findl2aEmpnoByGroupLevel();
		List<EmployeeGroupLevelDto> dropList1 = orika.mapAsList(l2aEmpnoMapList, EmployeeGroupLevelDto.class);
		return dropList1; // 如果查詢沒有結果，會返回空的 List
	}

	// 組織人員維護 下拉l2b Empno
	@Override
	public List<EmployeeGroupLevelDto> findl2bEmpnoByGroupLevel() {
		List<Map<String, Object>> l2bEmpnoMapList = cFEmployeeRepository.findl2bEmpnoByGroupLevel();
		List<EmployeeGroupLevelDto> dropList2 = orika.mapAsList(l2bEmpnoMapList, EmployeeGroupLevelDto.class);
		return dropList2; // 如果查詢沒有結果，會返回空的 List
	}

	// 組織人員維護 下拉codeDesc
	@Override
	public List<CFMappingGroupLevelDto> findCodeNoAndCodeDescByGroupLevel() {
		List<Map<String, Object>> codeDescMapList = cFEmployeeRepository.findCodeNoAndCodeDescByGroupLevel();
		List<CFMappingGroupLevelDto> codeGroupLevelDropList = orika.mapAsList(codeDescMapList, CFMappingGroupLevelDto.class);
		return codeGroupLevelDropList; // 如果查詢沒有結果，會返回空的 List
	}

	// 組織人員維護 下拉codeNo
	@Override
	public List<CFMappingCodeYnDto> findCodeNoAndCodeDescByYn() {
		List<Map<String, Object>> codeNoMapList = cFEmployeeRepository.findCodeNoAndCodeDescByYn();
		List<CFMappingCodeYnDto> codeYnDropList = orika.mapAsList(codeNoMapList, CFMappingCodeYnDto.class);
		return codeYnDropList; // 如果查詢沒有結果，會返回空的 List
	}

	// 系統代碼維護 新增
	@Transactional
	public void saveEmployee(CFEmployeeDto dto) {
		String empNo = dto.getEmpNo();
		CFEmployeeEntity dbEmployeeEntity = cFEmployeeRepository.findByempNo(empNo);

		if (dbEmployeeEntity == null) {
			CFEmployeeEntity employeeEntity = new CFEmployeeEntity();
			orika.map(dto, employeeEntity);
			cFEmployeeRepository.save(employeeEntity);
		} else {
			// 資料存在 → 更新（使用 Orika 將 dto 值複製到原本的 entity 上）
			dbEmployeeEntity.setEmpNo(dto.getEmpNo());
			dbEmployeeEntity.setEmpName(dto.getEmpName());
			dbEmployeeEntity.setOnJob(dto.getOnJob());
			dbEmployeeEntity.setEmpId(dto.getEmpId());
			dbEmployeeEntity.setEmail(dto.getEmail());
			dbEmployeeEntity.setAssignStop(dto.getAssignStop());
			dbEmployeeEntity.setL2aEmpno(dto.getL2aEmpno());
			dbEmployeeEntity.setL2bEmpno(dto.getL2bEmpno());
			cFEmployeeRepository.save(dbEmployeeEntity);
		}
	}
	
	@Override
	// 判斷登入者派件層級
	public OpIdDto findOpIdByEmpNo(String empNo){
		Map<String, Object> map = cFEmployeeRepository.findGroupLevelByEmpNo(empNo);
		if(StringUtils.isBlank(empNo)) {
			throw new IllegalArgumentException("empNo 不可為空");
		}
		String groupLevel = map.get("GROUP_LEVEL") != null ? map.get("GROUP_LEVEL").toString(): "";
	    String opId = null;
	    if (groupLevel != null) {
	        switch (groupLevel.toUpperCase()) {
	            case "L1":
	                opId = "1290";
	                break;
	            case "L2A":
	                opId = "1270";
	                break;
	            case "L2B":
	                opId = "1250";
	                break;
	            case "L3":
	                opId = "1220";
	                break;
	            default:
	                // 可加上預設處理
	                break;
	        }
	    }
	    OpIdDto dto = orika.map(map, OpIdDto.class);
	    dto.setOpId(opId);
	    return dto;
	}

}
