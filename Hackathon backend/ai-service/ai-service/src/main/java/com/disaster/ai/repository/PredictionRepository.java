package com.disaster.ai.repository;

import com.disaster.ai.entity.PredictionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PredictionRepository extends JpaRepository<PredictionRecord, Long> {}
