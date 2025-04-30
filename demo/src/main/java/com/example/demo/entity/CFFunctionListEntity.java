package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CF_FUNCTION_LIST")
public class CFFunctionListEntity {

    @Id
    private String fnNo;

    private String fnGroupNo;

    private String fnPath;

    private Integer fnSort;

    private String fnDesc;
}
