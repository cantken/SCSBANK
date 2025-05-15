package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CastListDto {
private String opId;                 // 作業代碼
	private String empNo;            // 員工編號
	private String opDesc;           // 作業描述
	private String applno;           // 收件編號
	private String cuId;             // 身分證字號
	private String cuName;           // 中文姓名
	private String cardType;         // 代碼說明　->　卡別
	private String fraudType;        // 代碼說明　–>　詐欺類型
	private String caseInputTime;    // 建檔時間

}

		
		
		