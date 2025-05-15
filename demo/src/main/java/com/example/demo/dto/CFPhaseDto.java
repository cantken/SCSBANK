package com.example.demo.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CFPhaseDto {
	
    private String applno;           // 收件編號
    private String opId;             // 作業代碼
    private String statusId;         // 狀態代碼
    private LocalDateTime startDate; // 作業開始時間
    private LocalDateTime endDate;   // 作業結束時間

}