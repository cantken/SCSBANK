package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CFFunctionListDto {

	@JsonAlias("FN_NO")
	private String fnNo;       // 功能代碼

	@JsonAlias("FN_GROUP_NO")
	private String fnGroupNo;  // 程式代碼

	@JsonAlias("FN_PATH")
	private String fnPath;     // 程式路徑

	@JsonAlias("FN_SORT")
	private Integer fnSort;    // 排序

	@JsonAlias("FN_DESC")
	private String fnDesc;     // 程式名稱
    
}