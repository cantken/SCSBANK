package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CF_CASEINFO")
public class CFCaseinfoEntity {

	@Id
	private String applno;
	
	private String cuName;
	
	private String cuId;
	
	private String cuBirthday;
	
	private String cuBillCode;
	
	private String cuBillAddr;
	
	@Column(name = "CU_H_TEL")
	private String cuHTel;
	
	private String cuCpTel;
	
	@Column(name = "CU_M_TEL")
	private String cuMTel;
	
	private String cuEmail;
	
	private String cuCpName;
	
	private String cardFlag;
	
	private String fraudType;
	
	private String cardType;
	
	private String agreeChange;
	
	private String agreePrint;
	
	private String cuSendCode;
	
	private String cuSendAddr;

}