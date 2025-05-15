package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CFOpStatusDto {
    private String opId;    // 作業代碼
    private String opDesc;  // 作業描述
    private String note;    // 備註

}