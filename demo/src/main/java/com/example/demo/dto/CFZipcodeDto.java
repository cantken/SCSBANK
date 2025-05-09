package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CFZipcodeDto {
	
    private String zipNo;    // 郵遞區號
    private String fkNo;     // 縣市編號
    private String zipName;  // 行政區名
	
}