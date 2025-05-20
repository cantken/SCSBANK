package com.example.demo.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CFPhaseDto {
	
	@JsonAlias("APPLNO")
	private String applno;           // 收件編號

	@JsonAlias("OP_ID")
	private String opId;             // 作業代碼

	@JsonAlias("STATUS_ID")
	private String statusId;         // 狀態代碼

	@JsonAlias("START_DATE")
	private LocalDateTime startDate; // 作業開始時間

	@JsonAlias("END_DATE")
	private LocalDateTime endDate;   // 作業結束時間


}