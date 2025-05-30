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
@IdClass(ZipNoAndZipNameId.class)
@Table(name = "CF_ZIPCODE")
public class CFZipcodeEntity {
	
	@Id
    private String zipNo;
	
	@Id
    private String fkNo;

    private String zipName;
	

}
