package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CFPhaseEntity;
import com.example.demo.entity.CFPhaseId;

public interface CFPhaseRepository extends JpaRepository<CFPhaseEntity, CFPhaseId> {

}
