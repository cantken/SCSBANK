package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardTypeDto {
	
	@JsonAlias("CODE_CATEGORY")
	private String codeType;    // 代碼類別

	@JsonAlias("CODE_NUMBER")
	private String codeNo;      // 代碼

	@JsonAlias("CODE_DESCRIPTION")
	private String codeDesc;    // 代碼說明

}
