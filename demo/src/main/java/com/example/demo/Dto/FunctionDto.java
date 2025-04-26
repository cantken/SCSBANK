package com.example.demo.Dto;

import lombok.Data;

@Data
public class FunctionDto {
	
	private String codeDesc;  // 群組名稱
    private String fnPath;    // 功能路徑
    private String fnDesc;    // 功能說明
    
	public String getCodeDesc() {
		return codeDesc;
	}
	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}
	public String getFnPath() {
		return fnPath;
	}
	public void setFnPath(String fnPath) {
		this.fnPath = fnPath;
	}
	public String getFnDesc() {
		return fnDesc;
	}
	public void setFnDesc(String fnDesc) {
		this.fnDesc = fnDesc;
	}
	
	@Override
	public String toString() {
	    return "FunctionDto{" +
	           "codeDesc='" + codeDesc + '\'' +
	           ", fnPath='" + fnPath + '\'' +
	           ", fnDesc='" + fnDesc + '\'' +
	           '}';
	}
    
}
