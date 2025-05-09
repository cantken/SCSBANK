package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CF_PHASE")
public class CFPhaseEntity {
	
	@Id
    private String applno;

    private String opId;

    private String statusId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

}
