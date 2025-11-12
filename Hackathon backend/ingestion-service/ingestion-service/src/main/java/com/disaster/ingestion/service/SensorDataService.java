package com.disaster.ingestion.service;

import com.disaster.ingestion.entity.SensorData;
import com.disaster.ingestion.kafka.KafkaProducerService;
import com.disaster.ingestion.repository.SensorDataRepository;
import org.springframework.stereotype.Service;

@Service
public class SensorDataService {

    private final SensorDataRepository repo;
    private final KafkaProducerService kafkaProducer;

    public SensorDataService(SensorDataRepository repo, KafkaProducerService kafkaProducer) {
        this.repo = repo;
        this.kafkaProducer = kafkaProducer;
    }

    public SensorData ingest(SensorData data) {
        SensorData saved = repo.save(data);
        kafkaProducer.sendSensorData(saved);
        return saved;
    }
}
