package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleNoDto {

	@JsonAlias({"ROLE_NO"})
	private String roleNo;

	@JsonAlias({"ROLE_NAME"})
	private String roleName;

	@JsonAlias({"EMP_NO"})
	private String empNo;
}
