package com.example.demo.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CFAuthDataDto {

    @JsonAlias("APPLNO")
    private String applno;        // 收件編號

    @JsonAlias("CHOICE")
    private String choice;        // 點選

    private LocalDate tradeDate;     // 交易日期

    @JsonAlias("TRADR_TIME")
    private String tradrTime;  // 交易時間

    @JsonAlias("AC_BANK")
    private String acBank;        // 收單銀行

    @JsonAlias("SHOP_CODE")
    private String shopCode;      // 商店代號

    @JsonAlias("MCC")
    private String mcc;           // MCC

    @JsonAlias("TRADE_COUNTRY")
    private String tradeCountry;  // 交易國別

    @JsonAlias("TRADE_MONEY")
    private Integer tradeMoney;      // 交易金額

    @JsonAlias("AUTH_CODE")
    private String authCode;      // 授權碼

    @JsonAlias("EM")
    private String em;            // EM

    @JsonAlias("MF_CODE")
    private String mfCode;        // 微縮影編號
    
    @JsonAlias("TRADE_DATE")
    private String tradeDateStr;  // 交易時間
    
    @JsonAlias("UUID")
    private String uuid;  // uuid
}