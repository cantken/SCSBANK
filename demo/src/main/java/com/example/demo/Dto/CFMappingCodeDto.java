package com.example.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CFMappingCodeDto {

	    private String codeType;

	    private String codeNo;

	    private String codeDesc;

	    private Integer codeSort;

	    private String codeTag;

	    private String codeFlag;


}
