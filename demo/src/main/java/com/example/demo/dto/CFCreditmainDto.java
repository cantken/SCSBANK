package com.example.demo.dto;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CFCreditmainDto {
	private String applno;               // 收件編號
	private String opId;                 // 作業代碼
	private Date billDate;               // 帳單結帳日
	private BigDecimal authNum;          // 授權筆數
	private BigDecimal authMoney;        // 授權金額
	private BigDecimal requestNum;       // 請款筆數
	private BigDecimal requestMoney;     // 請款金額
	private BigDecimal cbMoney;          // CB成功金額
	private BigDecimal cuPaymentMoney;   // 客戶承擔金額
	private BigDecimal bankPaymentMoney; // 本行承擔金額
	private String fscAppeal;            // 金管會申訴
	private Date fscAppealDate;          // 金管會申訴日期
	private String foiAppeal;            // 金融評議中心申訴
	private Date foiAppealDate;          // 金融評議中心申訴日期
	private String judiciaryName;        // 司法機關來函查詢-機關名稱
	private Date judiciaryDate;          // 司法機關來函查詢-日期
	private String suspectName;          // 嫌犯姓名
	private String suspectId;            // 嫌犯ID
	private String stealingFeature;      // 盜刷特徵
	private String caseSource;           // 案件提報來源
	private String csrauthOpinion;       // 客服或授權受理意見
	private String riskOpinion;          // 風管組處理意見
	private Date caseInputTime;          // 建檔時間
	private String l3empno;              // 初審員編
	private String l2bempno;             // 覆審B員編
	private String l2aempno;             // 覆審B員編
	private String l1empno;              // 卡中心主管員編
}