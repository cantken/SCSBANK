package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CFMappingCodeDto {
	private String codeType; //代碼類別
	private String codeNo; //代碼
	private String codeDesc; //代碼說明
	private Integer codeSort; //排序
	private String codeTag; //代碼標籤
	private String codeFlag; //停用FLAG
	private String forRowid; //oracle內建 froeRowid
}
