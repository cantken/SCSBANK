package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CF_AUTH_DATA")
@IdClass(ApplnoAndUuId.class) // 使用複合主鍵
public class CFAuthDataEntity {
	
	@Id
	@Column(name = "APPLNO")
	private String applno; // 收件編號
	
	@Id
	@Column(name = "UUID")
	private String uuid; // uuid

	@Column(name = "CHOICE")
	private String choice; // 點選
	
	@Column(name = "TRADE_DATE")
	private String tradeDate; // 交易日期
	
	@Column(name = "TRADR_TIME")
	private String tradrTime; // 交易時間

	@Column(name = "AC_BANK")
	private String acBank; // 收單銀行

	@Column(name = "SHOP_CODE")
	private String shopCode; // 商店代號

	@Column(name = "MCC")
	private String mcc; // MCC

	@Column(name = "TRADE_COUNTRY")
	private String tradeCountry; // 交易國別

	@Column(name = "TRADE_MONEY")
	private Integer tradeMoney; // 交易金額

	@Column(name = "AUTH_CODE")
	private String authCode; // 授權碼

	@Column(name = "EM")
	private String em; // EM

	@Column(name = "MF_CODE")
	private String mfCode; // 微縮影編號

}
