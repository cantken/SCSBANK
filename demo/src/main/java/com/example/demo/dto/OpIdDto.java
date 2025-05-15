package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpIdDto {
	
    private String empNo;      // 員工編號
    private String groupLevel; // 派件層級
    private String opId;       // 作業代碼
 
}
