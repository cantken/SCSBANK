package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CF_BATCH_PARA")
@IdClass(CFBatchParaId.class) // 使用複合主鍵
public class CFBatchParaEntity {

	@Id
	private String batchName;

	@Id
	private String batchType;

	private String para1;

	private String para2;

}
