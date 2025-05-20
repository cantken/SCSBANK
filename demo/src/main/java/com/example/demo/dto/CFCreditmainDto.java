package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CFCreditmainDto {
	
	@JsonAlias("APPLNO")
	private String applno;               // 收件編號

	@JsonAlias("OP_ID")
	private String opId;                 // 作業代碼

	@JsonAlias("BILL_DATE")
	private LocalDateTime billDate;               // 帳單結帳日

	@JsonAlias("AUTH_NUM")
	private BigDecimal authNum;          // 授權筆數

	@JsonAlias("AUTH_MONEY")
	private BigDecimal authMoney;        // 授權金額

	@JsonAlias("REQUEST_NUM")
	private BigDecimal requestNum;       // 請款筆數

	@JsonAlias("REQUEST_MONEY")
	private BigDecimal requestMoney;     // 請款金額

	@JsonAlias("CB_MONEY")
	private BigDecimal cbMoney;          // CB成功金額

	@JsonAlias("CU_PAYMENT_MONEY")
	private BigDecimal cuPaymentMoney;   // 客戶承擔金額

	@JsonAlias("BANK_PAYMENT_MONEY")
	private BigDecimal bankPaymentMoney; // 本行承擔金額

	@JsonAlias("FSC_APPEAL")
	private String fscAppeal;            // 金管會申訴

	@JsonAlias("FSC_APPEAL_DATE")
	private LocalDateTime fscAppealDate;          // 金管會申訴日期

	@JsonAlias("FOI_APPEAL")
	private String foiAppeal;            // 金融評議中心申訴

	@JsonAlias("FOI_APPEAL_DATE")
	private LocalDateTime foiAppealDate;          // 金融評議中心申訴日期

	@JsonAlias("JUDICIARY_NAME")
	private String judiciaryName;        // 司法機關來函查詢-機關名稱

	@JsonAlias("JUDICIARY_DATE")
	private LocalDateTime judiciaryDate;          // 司法機關來函查詢-日期

	@JsonAlias("SUSPECT_NAME")
	private String suspectName;          // 嫌犯姓名

	@JsonAlias("SUSPECT_ID")
	private String suspectId;            // 嫌犯ID

	@JsonAlias("STEALING_FEATURE")
	private String stealingFeature;      // 盜刷特徵

	@JsonAlias("CASE_SOURCE")
	private String caseSource;           // 案件提報來源

	@JsonAlias("CSRAUTH_OPINION")
	private String csrauthOpinion;       // 客服或授權受理意見

	@JsonAlias("RISK_OPINION")
	private String riskOpinion;          // 風管組處理意見

	@JsonAlias("CASE_INPUT_TIME")
	private LocalDateTime caseInputTime;          // 建檔時間

	@JsonAlias("L3EMPNO")
	private String l3empno;              // 初審員編

	@JsonAlias("L2BEMPNO")
	private String l2bempno;             // 覆審B員編

	@JsonAlias("L2AEMPNO")
	private String l2aempno;             // 覆審B員編

	@JsonAlias("L1EMPNO")
	private String l1empno;              // 卡中心主管員編

	
}