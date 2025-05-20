package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CFEmployeeDto {
	
	@JsonAlias("EMP_NO")
	private String empNo;       // 員工編號

	@JsonAlias("EMP_NAME")
	private String empName;     // 員工姓名

	@JsonAlias("ON_JOB")
	private String onJob;       // 是否在職

	@JsonAlias("EMAIL")
	private String email;       // E-MAIL

	@JsonAlias("L2A_EMPNO")
	private String l2aEmpno;    //覆審A送件主管

	@JsonAlias("L2B_EMPNO")
	private String l2bEmpno;    //覆審B送件主管

	@JsonAlias("ASSIGN_STOP")
	private String assignStop;  // 是否停派

	@JsonAlias("EMP_ID")
	private String empId;       // 員工ID

	@JsonAlias("GROUP_LEVEL")
	private String groupLevel;  // 派件層級

	@JsonAlias("ROLE_NO")
	private String roleNo;      // 角色
    
}
