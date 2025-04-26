package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.Dto.CFMappingCodeDropDownDto;
import com.example.demo.Dto.CFMappingCodeDto;
import com.example.demo.entity.CFMappingCodeEntity;
import com.example.demo.repository.CFMappingCodeRepository;
import com.example.demo.service.CFMappingCodeService;

import jakarta.transaction.Transactional;
import ma.glasnost.orika.MapperFacade; // 正確的 Orika MapperFacade 導入

@Service
public class CFMappingCodeServiceImpl implements CFMappingCodeService {

	private final CFMappingCodeRepository cFMappingCodeRepository;
	private final MapperFacade orika;

	public CFMappingCodeServiceImpl(CFMappingCodeRepository cFMappingCodeRepository, MapperFacade orika) {
		this.cFMappingCodeRepository = cFMappingCodeRepository;
		this.orika = orika;
	}

	// 系統代碼維護 下拉選單
	@Override
	public List<CFMappingCodeDropDownDto> findCodeNoDescByCodeType(String codeType) {
		if (codeType == null || codeType.isEmpty()) {
			codeType = "sysType";
		}
		List<Map<String, Object>> cFMappingCodeMapList = cFMappingCodeRepository.findCodeNoDescByCodeType(codeType);
		List<CFMappingCodeDropDownDto> dropList = new ArrayList<>();

		for (Map<String, Object> map : cFMappingCodeMapList) {
			CFMappingCodeDropDownDto dto = new CFMappingCodeDropDownDto();
			// 假設您的 Map 中包含 "codeNo" 和 "codeDesc" 鍵，請根據實際情況調整鍵名
			dto.setCodeNo((String) map.get("codeNo"));
			dto.setCodeDesc((String) map.get("codeDesc"));
			dropList.add(dto);
		}
		return dropList;
	}

	// 系統代碼維護 搜尋
	@Override
	public List<CFMappingCodeDto> findByCodeType(String codeType) {
		List<CFMappingCodeDto> dtoList = new ArrayList<>();
		List<CFMappingCodeEntity> cFMappingCodeList = cFMappingCodeRepository.findListByCodeType(codeType);
		dtoList = orika.mapAsList(cFMappingCodeList, CFMappingCodeDto.class);
		return dtoList; // 如果查詢沒有結果，會返回空的 List
	}

	// 系統代碼維護 新增
	@Transactional
	public void saveMappingCode(CFMappingCodeDto cFMappingCodeDto) {
		CFMappingCodeEntity entity = orika.map(cFMappingCodeDto, CFMappingCodeEntity.class);
		cFMappingCodeRepository.save(entity);
	}
	
	// 系統代碼維護 修改
	@Transactional
	public CFMappingCodeDto updateMappingCode(CFMappingCodeDto cFMappingCodeDto) {
	    String codeTyoe = cFMappingCodeDto.getCodeType(); // 假設主鍵為 id
	    CFMappingCodeEntity entity = cFMappingCodeRepository.findByCodeType(codeTyoe);
	    
	    if(entity != null) {
	    	orika.map(cFMappingCodeDto, entity);
	    	CFMappingCodeEntity savedEntity = cFMappingCodeRepository.save(entity);
	    	return orika.map(savedEntity, CFMappingCodeDto.class);
	    }else {
	    	throw new RuntimeException("找不到資料，無法更新");
	    }
	}
	

}
