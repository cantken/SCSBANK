package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CFFunctionListDto {

    private String fnNo;       // 功能代碼 
    private String fnGroupNo;  // 程式代碼 
    private String fnPath;     // 程式路徑 
    private Integer fnSort;    // 排序 
    private String fnDesc;     // 程式名稱 
}