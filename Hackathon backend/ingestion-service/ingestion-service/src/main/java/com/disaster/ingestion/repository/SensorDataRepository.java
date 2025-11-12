package com.disaster.ingestion.repository;

import com.disaster.ingestion.entity.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {}
