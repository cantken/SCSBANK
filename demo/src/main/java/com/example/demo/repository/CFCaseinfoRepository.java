package com.example.demo.repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CFCaseinfoEntity;

public interface CFCaseinfoRepository extends JpaRepository<CFCaseinfoEntity, String> {
	@Query(value = "SELECT A.APPLNO,CU_ID, CU_NAME, D.CODE_DESC AS CARD_TYPE, E.CODE_DESC AS FRAUD_TYPE, L3EMPNO "
			+ "FROM CF_CASEINFO A INNER JOIN CF_CREDITMAIN B ON A.APPLNO=B.APPLNO "
			+ "INNER JOIN CF_OP_STATUS C ON B.OP_ID=C.OP_ID "
			+ "LEFT JOIN CF_MAPPING_CODE D ON A.CARD_TYPE=D.CODE_NO AND D.CODE_TYPE='CARD_TYPE' "
			+ "LEFT JOIN CF_MAPPING_CODE E ON A.FRAUD_TYPE=E.CODE_NO AND E.CODE_TYPE='FRAUD_TYPE' "
			+ "WHERE (:applno IS NULL OR A.APPLNO = :applno) "
			+ "AND (:cuId IS NULL OR A.CU_ID = :cuId) "
			+ "AND (:cuName IS NULL OR A.CU_NAME = :cuName) "
			+ "AND (:l3empno IS NULL OR B.L3EMPNO = :l3empno) "
			+ "AND (:caseInputTime IS NULL OR B.CASE_INPUT_TIME = :caseInputTime) ORDER BY A.APPLNO ", nativeQuery = true)
	public List<Map<String, Object>> findCaseInfo(
			@Param("applno") String applno,
		    @Param("cuName") String cuName,
		    @Param("cuId") String cuId,
		    @Param("l3empno") String l3empno,
		    @Param("caseInputTime") Date caseInputTime
		    );
}	