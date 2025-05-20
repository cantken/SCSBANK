package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeGroupLevelDto {

	@JsonAlias("EMP_NO")
	private String empNo;   // 員工編號

	@JsonAlias("EMP_NAME")
	private String empName; // 員工姓名
	
}
