package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.ApplnoAndUuId;
import com.example.demo.entity.CFAuthDataEntity;

public interface CFAuthDataRepository extends JpaRepository<CFAuthDataEntity, ApplnoAndUuId> {
	@Query(value = "SELECT "
		      + "a.APPLNO, "
		      + "a.CHOICE, "
		      + "a.TRADE_DATE, "
		      + "a.TRADR_TIME, "
		      + "a.AC_BANK, "
		      + "a.SHOP_CODE, "
		      + "a.MCC, "
		      + "a.TRADE_COUNTRY, "
		      + "a.TRADE_MONEY, "
		      + "a.AUTH_CODE, "
		      + "a.EM, "
		      + "a.MF_CODE, "
		      + "a.UUID "
		      + "FROM CF_AUTH_DATA a "
		      + "WHERE (:applno IS NULL OR a.APPLNO = :applno) "
		      + "AND (:tradeDate IS NULL OR a.TRADE_DATE = :tradeDate) ", 
		      nativeQuery = true)
		List<Map<String, Object>> findAllByApplNoAndTradeDate(@Param("applno") String applno, @Param("tradeDate") String tradeDateStr);


	List<CFAuthDataEntity> findAllByApplno(String applno);
	
	List<CFAuthDataEntity> findAllByUuid(String uuid);
	

	void deleteByApplno(String applno);

}
