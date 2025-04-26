package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CF_FUNCTION_LIST")
public class CFFunctionListEntity {

    @Id
    @Column(name = "FN_NO")
    private String fnNo;

    @Column(name = "FN_GROUP_NO")
    private String fnGroupNo;

    @Column(name = "FN_PATH")
    private String fnPath;

    @Column(name = "FN_SORT")
    private Integer fnSort;

    @Column(name = "FN_DESC")
    private String fnDesc;
}
