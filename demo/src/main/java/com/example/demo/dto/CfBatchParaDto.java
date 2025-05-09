package com.example.demo.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CfBatchParaDto {

	private String batchName;  // 批次名稱
	private String batchType;  // 批次型式
	private String para1;      // 參數1
	private String para2;      // 參數2

}



