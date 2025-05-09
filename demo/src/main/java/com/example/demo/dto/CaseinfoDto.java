package com.example.demo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CaseinfoDto {
	private String applno;      // 收件編號
	private String cuId;        // 身分證字號
	private String cuName;      // 中文姓名
	private String cardType;    // 這裡放 D.CODE_DESC → 卡片類型說明
    private String fraudType;   // 這裡放 E.CODE_DESC → 詐欺類型說明
	private String l3empno;     // 初審員編
	private Date caseInputTime; // 建檔時間
	private String caseInputTimeStr;
}