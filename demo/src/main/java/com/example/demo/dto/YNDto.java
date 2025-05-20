package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YNDto {
	
	@JsonAlias({"CODE_TYPE"})
	private String codeType; // 代碼類別

	@JsonAlias({"CODE_NO"})
	private String codeNo; // 代碼

	@JsonAlias({"CODE_DESC"})
	private String codeDesc; // 代碼說明

}
