package com.example.demo.dto;
import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CfBatchParaDto {

	@JsonAlias("BATCH_NAME")
	private String batchName;  // 批次名稱

	@JsonAlias("BATCH_TYPE")
	private String batchType;  // 批次型式

	@JsonAlias("PARA1")
	private String para1;      // 參數1

	@JsonAlias("PARA2")
	private String para2;      // 參數2


}



