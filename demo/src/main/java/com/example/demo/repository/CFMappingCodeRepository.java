package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CFMappingCodeEntity;
import com.example.demo.entity.CFMappingCodeId;

@Repository
public interface CFMappingCodeRepository extends JpaRepository<CFMappingCodeEntity, CFMappingCodeId> {
    @Query(value = " SELECT CODE_NO, CODE_DESC FROM CF_MAPPING_CODE ORDER BY CODE_SORT", nativeQuery = true)
    List<Map<String, Object>> findCodeNoDescByCodeType(@Param("codeType") String codeType);
    
    List<CFMappingCodeEntity> findListByCodeType(@Param("codeType") String codeType);
    
    CFMappingCodeEntity findByCodeType(@Param("codeType") String codeType);
    
}