package com.example.demo.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CFBatchParaEntity;
import com.example.demo.entity.CFBatchParaId;

public interface CFBatchParaRepository extends JpaRepository<CFBatchParaEntity, CFBatchParaId>{
	@Query(value = "SELECT a.PARA2 FROM CF_BATCH_PARA a WHERE a.BATCH_NAME='APPLNO' AND a.BATCH_TYPE= 'C' AND a.PARA1= :para1", nativeQuery = true)
	public Map<String, Object> findPara2(@Param("para1") String para1);
	
	@Query(value = "SELECT MAX(TO_NUMBER(SUBSTR(PARA2, -3))) FROM CF_BATCH_PARA WHERE BATCH_NAME = 'APPLNO' AND BATCH_TYPE = 'C' AND PARA1 LIKE CONCAT(:date, 'A%')", nativeQuery = true)
	Integer findCurrentSerial(@Param("date") String date); // date 傳入 yyyyMMdd

}
