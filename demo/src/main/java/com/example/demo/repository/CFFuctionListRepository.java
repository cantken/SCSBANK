package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.CFFunctionListEntity;

public interface CFFuctionListRepository extends JpaRepository<CFFunctionListEntity, String> {

	@Query(value = "SELECT b.CODE_DESC, a.FN_NO, a.FN_DESC FROM CF_FUNCTION_LIST a "
			+ "INNER JOIN CF_MAPPING_CODE b ON a.FN_GROUP_NO = b.CODE_NO "
			+ "AND b.CODE_TYPE = 'FN_GROUP' ORDER BY a.FN_GROUP_NO, a.FN_SORT", nativeQuery = true)
	List<Map<String, Object>> findFunctionRoleSet();

}
