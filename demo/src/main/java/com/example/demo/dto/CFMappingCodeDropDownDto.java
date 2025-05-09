package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CFMappingCodeDropDownDto {

    private String codeType;
    private String codeNo;
    private String codeDesc;

 
    @Override
    public String toString() {
        return "CFMappingCodeDropDownDto{" +
                "codeType='" + codeType + '\'' +
                ", codeNo='" + codeNo + '\'' +
                ", codeDesc='" + codeDesc + '\'' +
                '}';
    }
}
