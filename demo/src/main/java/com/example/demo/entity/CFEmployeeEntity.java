package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CF_EMPLOYEE")
public class CFEmployeeEntity {

	@Id
	private String empNo;

	private String empName;

	private String onJob;

	private String email;

	private String l2aEmpno;

	private String l2bEmpno;

	private String assignStop;

	private String empId;

	private String groupLevel;

}
