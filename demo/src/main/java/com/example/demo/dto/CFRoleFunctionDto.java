package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CFRoleFunctionDto {
	
    private String roleNo;  // 角色代碼
    
    private String fnNo;    // 程式代碼
}