package com.example.demo.entity;

import org.hibernate.annotations.Formula;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@IdClass(CFMappingCodeId.class)
@Table(name = "CF_MAPPING_CODE")
public class CFMappingCodeEntity {

    @Id
    @Column(name = "CODE_NO")
    private String codeNo;

    @Id
    @Column(name = "CODE_TYPE")
    private String codeType;

    @Column(name = "CODE_DESC")
    private String codeDesc;

    @Column(name = "CODE_SORT")
    private Integer codeSort;

    @Column(name = "CODE_TAG")
    private String codeTag;

    @Column(name = "CODE_FLAG")
    private String codeFlag;
    
    @Formula("ROWID")
    private String forRowid;
    
}
