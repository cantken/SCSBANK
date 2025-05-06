package com.example.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeGroupLevelDto {
	private String empNo; //員工編號
    private String empName; //員工姓名
}
