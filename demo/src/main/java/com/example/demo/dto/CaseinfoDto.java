package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CaseinfoDto {
	
	@JsonAlias("APPLICATION_NUMBER")
	private String applno;          // 收件編號

	@JsonAlias("CHINESE_NAME")
	private String cuName;          // 中文姓名

	@JsonAlias("ID_NUMBER")
	private String cuId;            // 身分證字號

	@JsonAlias("BIRTHDAY")
	private String cuBirthday;      // 生日(YYYYMMDD)

	@JsonAlias("BILLING_ADDRESS")
	private String cuBillAddr;      // 帳單地址

	@JsonAlias("HOME_TEL")
	private String cuHTel;          // 住宅電話

	@JsonAlias("COMPANY_TEL")
	private String cuCpTel;         // 公司電話

	@JsonAlias("MOBILE_TEL")
	private String cuMTel;          // 行動電話

	@JsonAlias("EMAIL")
	private String cuEmail;         // E-MAIL

	@JsonAlias("COMPANY_NAME")
	private String cuCpName;        // 公司名稱

	@JsonAlias("CARD_FLAG")
	private String cardFlag;	    // 卡片FLAG

	@JsonAlias("FRAUD_TYPE")
	private String fraudType;       // 詐欺類型

	@JsonAlias("CARD_TYPE")
	private String cardType;        // 卡別

	@JsonAlias("AGREE_TO_CHANGE")
	private String agreeChange;     // 是否同意改發

	@JsonAlias("AGREE_TO_PRINT")
	private String agreePrint;      // 是否列印通知函

	@JsonAlias("SEND_CODE")
	private String cuSendCode;      // 通知函寄送郵區

	@JsonAlias("SEND_ADDRESS")
	private String cuSendAddr;      // 通知函寄送地址


}