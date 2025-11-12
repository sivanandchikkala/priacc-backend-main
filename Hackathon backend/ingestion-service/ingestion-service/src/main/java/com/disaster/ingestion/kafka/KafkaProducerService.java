package com.disaster.ingestion.kafka;

import com.disaster.ingestion.entity.SensorData;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, SensorData> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, SensorData> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendSensorData(SensorData data) {
        kafkaTemplate.send("sensor-data-topic", data);
        System.out.println("📤 Sent to Kafka: " + data);
    }
}
