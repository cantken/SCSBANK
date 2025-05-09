package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CFRoleDto {

	private String roleNo;

	private String roleName;
	
	private boolean selected; // 代表這筆是否被選中

}
