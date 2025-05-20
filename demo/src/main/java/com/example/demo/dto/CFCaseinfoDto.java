package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CFCaseinfoDto {

	@JsonAlias("APPLNO")
	private String applno;      // 收件編號

	@JsonAlias("CU_NAME")
	private String cuName;      // 中文姓名

	@JsonAlias("CU_ID")
	private String cuId;        // 身分證字號

	@JsonAlias("CU_BIRTHDAY")
	private String cuBirthday;  // 生日(YYYYMMDD)

	@JsonAlias("CU_BILL_CODE")
	private String cuBillCode;  // 帳單地址郵區

	@JsonAlias("CU_BILL_ADDR")
	private String cuBillAddr;  // 帳單地址

	@JsonAlias("CU_HTEL")
	private String cuHTel;      // 住宅電話

	@JsonAlias("CU_CP_TEL")
	private String cuCpTel;     // 公司電話

	@JsonAlias("CU_MTEL")
	private String cuMTel;      // 行動電話

	@JsonAlias("CU_EMAIL")
	private String cuEmail;     // E-MAIL

	@JsonAlias("CU_CP_NAME")
	private String cuCpName;    // 公司名稱

	@JsonAlias("CARD_FLAG")
	private String cardFlag;    // 卡片FLAG

	@JsonAlias("FRAUD_TYPE")
	private String fraudType;   // 詐欺類型

	@JsonAlias("CARD_TYPE")
	private String cardType;    // 卡別

	@JsonAlias("AGREE_CHANGE")
	private String agreeChange; // 是否同意改發

	@JsonAlias("AGREE_PRINT")
	private String agreePrint;  // 是否列印通知函

	@JsonAlias("CU_SEND_CODE")
	private String cuSendCode;  // 通知函寄送郵區

    
}
