package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.CFMappingCodeDto;
import com.example.demo.entity.CFMappingCodeEntity;
import com.example.demo.entity.CFMappingCodeId;

@Repository
public interface CFMappingCodeRepository extends JpaRepository<CFMappingCodeEntity, CFMappingCodeId> {
	@Query(value = "SELECT CODE_NO AS codeNo, CODE_DESC AS codeDesc FROM CF_MAPPING_CODE WHERE CODE_TYPE = :codeType ORDER BY CODE_SORT", nativeQuery = true)
    List<Map<String, Object>> findCodeNoDescByCodeType(@Param("codeType") String codeType);
    
    List<CFMappingCodeEntity> findListByCodeType(@Param("codeType") String codeType);
    
  
//    CFMappingCodeEntity findByCodeTypeAndCodeNoOrderByCodeSort(@Param("codeType") String codeType, @Param("codeNo") String codeNo);
    
    @Query(value = "SELECT "
            + "a.CODE_TYPE AS codeType, "
            + "a.CODE_NO AS codeNo, "
            + "a.CODE_DESC AS codeDesc, "
            + "a.CODE_SORT AS codeSort, "
            + "a.CODE_TAG AS codeTag, "
            + "a.CODE_FLAG AS codeFlag, "
            + "a.ROWID AS forRowid "
            + "FROM CF_MAPPING_CODE a "
            + "WHERE a.ROWID = :forRowid "
            + "ORDER BY a.CODE_SORT", nativeQuery = true)
    Map<String, Object> findByForRowid(@Param("forRowid") String forRowid);

	void save(Map<String, Object> dbDto);
    
}