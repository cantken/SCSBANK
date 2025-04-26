package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CF_EMPLOYEE")
public class CFEmployeeEntity {
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "EMP_NO")
	    private String empNo;

	    @Column(name = "EMP_NAME")
	    private String empName;
	    
	    @Column(name = "ON_JOB")
	    private String onJob;
	    
	    @Column(name = "EMAIL")
	    private String email;
	    
	    @Column(name = "L2A_EMPNO")
	    private String l2aEmpno;
	    
	    @Column(name = "L2B_EMPNO")
	    private String l2bEmpno;
	    
	    @Column(name = "ASSIGN_STOP")
	    private String assignStop;
	    
	    @Column(name = "EMP_ID")
	    private String empId;
	    
	    @Column(name = "GROUP_LEVEL")
	    private String groupLevel;
	    

}
