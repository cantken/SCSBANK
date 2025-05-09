package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FunctionRoleSetDto {

	private String fnNo; // 程式代碼
	private String fnDesc;     // 程式名稱 
	private String codeDesc; //代碼說明
	
}
