
package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CastListDto {

	@JsonAlias("OP_ID")
	private String opId; // 作業代碼

	@JsonAlias("EMP_NO")
	private String empNo; // 員工編號

	@JsonAlias("OP_DESC")
	private String opDesc; // 作業描述

	@JsonAlias("APPLNO")
	private String applno; // 收件編號

	@JsonAlias("CU_ID")
	private String cuId; // 身分證字號

	@JsonAlias("CU_NAME")
	private String cuName; // 中文姓名

	@JsonAlias("CARD_TYPE")
	private String cardType; // 卡別說明

	@JsonAlias("FRAUD_TYPE")
	private String fraudType; // 詐欺類型說明

	@JsonAlias("CASE_INPUT_TIME")
	private String caseInputTime; // 建檔時間
    
}
