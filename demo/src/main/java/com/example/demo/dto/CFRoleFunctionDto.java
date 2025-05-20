package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CFRoleFunctionDto {
	
	@JsonAlias("ROLE_NO")
	private String roleNo;  // 角色代碼

	@JsonAlias("FN_NO")
	private String fnNo;    // 程式代碼
}