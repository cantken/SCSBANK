package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRoleDto {

	@JsonAlias("EMP_NO")
	private String empNo; // 員工編號

	@JsonAlias("ROLE_NO")
	private String roleNo; // 角色代碼

    
}
