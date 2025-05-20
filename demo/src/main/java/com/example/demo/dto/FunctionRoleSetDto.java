package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FunctionRoleSetDto {

	@JsonAlias("FN_NO")
	private String fnNo; // 程式代碼

	@JsonAlias("FN_DESC")
	private String fnDesc; // 程式名稱

	@JsonAlias("CODE_DESC")
	private String codeDesc; // 代碼說明
	
}
