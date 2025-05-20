package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CFMappingCodeDto {
	
	@JsonAlias({"code_type", "codeType"})
    private String codeType;  // 代碼類別

    @JsonAlias({"code_no", "codeNo"})
    private String codeNo;    // 代碼

    @JsonAlias({"code_desc", "codeDesc"})
    private String codeDesc;  // 代碼說明

    @JsonAlias({"code_sort", "codeSort"})
    private Integer codeSort; // 排序

    @JsonAlias({"code_tag", "codeTag"})
    private String codeTag;   // 代碼標籤

    @JsonAlias({"code_flag", "codeFlag"})
    private String codeFlag;  // 停用FLAG

    @JsonAlias({"for_rowid", "forRowid"})
    private String forRowid;  // oracle內建 forRowid
	
}
