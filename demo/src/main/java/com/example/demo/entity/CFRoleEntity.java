package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CF_ROLE")
public class CFRoleEntity {

	@Id
	private String roleNo;
	
	private String roleName;
	
	private String roleAmt;

}
