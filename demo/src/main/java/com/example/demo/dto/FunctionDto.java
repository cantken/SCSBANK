package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FunctionDto {
	private String codeDesc;  // 群組名稱
    private String fnPath;    // 功能路徑
    private String fnDesc;    // 功能說明

	@Override
	public String toString() {
	    return "FunctionDto{" +
	           "codeDesc='" + codeDesc + '\'' +
	           ", fnPath='" + fnPath + '\'' +
	           ", fnDesc='" + fnDesc + '\'' +
	           '}';
	}
    
}
