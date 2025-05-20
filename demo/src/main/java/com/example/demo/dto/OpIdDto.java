package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpIdDto {
	
	@JsonAlias({"EMP_NO"})
	private String empNo; // 員工編號

	@JsonAlias({"GROUP_LEVEL"})
	private String groupLevel; // 派件層級

	@JsonAlias({"OP_ID"})
	private String opId; // 作業代碼
 
}
