package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CFOpStatusDto {
	
	@JsonAlias("OP_ID")
	private String opId;    // 作業代碼

	@JsonAlias("OP_DESC")
	private String opDesc;  // 作業描述

	@JsonAlias("NOTE")
	private String note;    // 備註

}