package com.example.demo.Dto;

public class CFMappingCodeDropDownDto {

    private String codeType;
    private String codeNo;
    private String codeDesc;

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getCodeNo() {
        return codeNo;
    }

    public void setCodeNo(String codeNo) {
        this.codeNo = codeNo;
    }

    public String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }

    @Override
    public String toString() {
        return "CFMappingCodeDropDownDto{" +
                "codeType='" + codeType + '\'' +
                ", codeNo='" + codeNo + '\'' +
                ", codeDesc='" + codeDesc + '\'' +
                '}';
    }
}
