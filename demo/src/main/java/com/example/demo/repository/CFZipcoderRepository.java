package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CFZipcodeEntity;

public interface CFZipcoderRepository extends JpaRepository<CFZipcodeEntity, String>{
	
	@Query(value = "SELECT ZIP_NAME,ZIP_NO FROM CF_ZIPCODE WHERE FK_NO='F'", nativeQuery = true)
	public List<Map<String, Object>> findZipNameByAllFkNo();
	
	@Query(value = "SELECT ZIP_NAME,ZIP_NO FROM CF_ZIPCODE WHERE FK_NO='F'", nativeQuery = true)
	public List<Map<String, Object>> findZipNameByFkNo(@Param("fkNo") String fkNo);

}
