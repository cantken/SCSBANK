package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardFlagDto {
	
	private String codeType; // 代碼類別
	private String codeNo; // 代碼
	private String codeDesc; //代碼說明

}
