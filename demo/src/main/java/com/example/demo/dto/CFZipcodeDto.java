package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CFZipcodeDto {
	
	@JsonAlias("ZIP_NO")
	private String zipNo;    // 郵遞區號

	@JsonAlias("FK_NO")
	private String fkNo;     // 縣市編號

	@JsonAlias("ZIP_NAME")
	private String zipName;  // 行政區名
	
}