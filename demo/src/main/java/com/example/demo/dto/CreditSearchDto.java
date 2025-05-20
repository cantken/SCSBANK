package com.example.demo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditSearchDto {
	
	@JsonAlias("APPL_NO")
	private String applno;        // 收件編號

	@JsonAlias("CU_NAME")
	private String cuName;        // 身分證字號

	@JsonAlias("CU_ID")
	private String cuId;          // 中文姓名

	@JsonAlias("FRAUD_TYPE")
	private String fraudType;     // 詐欺類型（D.CODE_DESC）

	@JsonAlias("CARD_TYPE")
	private String cardType;      // 卡別（E.CODE_DESC）

	@JsonAlias("L3_EMPNO")
	private String l3empno;       // 初審員編

	@JsonAlias("CASE_INPUT_TIME")
	private Date caseInputTime;   // 建檔時間

	
	private String caseInputTimeStr;

}