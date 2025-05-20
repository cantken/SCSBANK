package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CFRoleDto {

	@JsonAlias("ROLE_NO")
	private String roleNo;

	@JsonAlias("ROLE_NAME")
	private String roleName;
	
	private boolean selected; // 代表這筆是否被選中

}
