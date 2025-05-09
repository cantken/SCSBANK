package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Table(name = "CF_CREDITMAIN")
public class CFCreditmainEntity {

	@Id
	private String applno;

	private String opId;

	private LocalDateTime billDate;

	private BigDecimal authNum;

	private BigDecimal authMoney;

	private BigDecimal requestNum;

	private BigDecimal requestMoney;

	private BigDecimal cbMoney;

	private BigDecimal cuPaymentMoney;

	private BigDecimal bankPaymentMoney;

	private String fscAppeal;

	private LocalDateTime fscAppealDate;

	private String foiAppeal;

	private LocalDateTime foiAppealDate;

	private String judiciaryName;

	private LocalDateTime judiciaryDate;

	private String suspectName;

	private String suspectId;

	private String stealingFeature;

	private String caseSource;

	private String csrauthOpinion;

	private String riskOpinion;

	private LocalDateTime caseInputTime;

	private String l3empno;

	private String l2bempno;

	private String l2aempno;

	private String l1empno;
}