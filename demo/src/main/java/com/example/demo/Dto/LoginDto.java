package com.example.demo.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
public class LoginDto {

    @Column(name = "EMP_NO")
    private String empNo;

    @Column(name = "EMP_NAME")
    private String empName;

    @Column(name = "ON_JOB")
    private String onJob;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "L2A_EMPNO")
    private String l2aEmpNo;

    @Column(name = "L2B_EMPNO")
    private String l2bEmpNo;

    @Column(name = "ASSIGN_STOP")
    private String assignStop;

    @Column(name = "EMP_ID")
    private String empId;

    @Column(name = "GROUP_LEVEL")
    private String groupLevel;
}