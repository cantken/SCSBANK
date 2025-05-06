package com.example.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CFEmployeeDto {
    private String empNo; //員工編號
    private String empName; //員工姓名
    private String onJob; //是否在職
    private String email; //E-MAIL
    private String l2aEmpno; //覆審A送件主管
    private String l2bEmpno; //覆審B送件主管
    private String assignStop; //是否停派
    private String empId; //員工ID
    private String groupLevel; //派件層級
    private String roleNo; //角色
}
