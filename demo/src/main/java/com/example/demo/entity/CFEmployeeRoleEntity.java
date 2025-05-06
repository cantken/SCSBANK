package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CF_EMPLOYEE_ROLE")
@IdClass(CFEmployeeRoleId.class) // 註明複合主鍵使用 CFEmployeeRoleId 類別
public class CFEmployeeRoleEntity {

    @Id
    private String empNo;
    
    @Id
    private String roleNo;
}
