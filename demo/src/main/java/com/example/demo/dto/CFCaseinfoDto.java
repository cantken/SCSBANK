package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CFCaseinfoDto {

	private String applno;      // 收件編號
	private String cuName;      // 中文姓名
	private String cuId;        // 身分證字號
	private String cuBirthday;  // 生日(YYYYMMDD)
	private String cuBillCode;  // 帳單地址郵區
	private String cuBillAddr;  // 帳單地址
	private String cuHTel;      // 住宅電話
	private String cuCpTel;     // 公司電話
	private String cuMTel;      // 行動電話
	private String cuEmail;     // E-MAIL
	private String cuCpName;    // 公司名稱
	private String cardFlag;    // 卡片FLAG
	private String fraudType;   // 詐欺類型
	private String cardType;    // 卡別
	private String agreeChange; // 是否同意改發
	private String agreePrint;  // 是否列印通知函
	private String cuSendCode;  // 通知函寄送郵區
}
