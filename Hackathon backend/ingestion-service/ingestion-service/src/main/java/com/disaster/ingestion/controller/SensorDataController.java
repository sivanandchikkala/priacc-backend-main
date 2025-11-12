package com.disaster.ingestion.controller;

import com.disaster.ingestion.entity.SensorData;
import com.disaster.ingestion.service.SensorDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ingest")
public class SensorDataController {

    private final SensorDataService service;

    public SensorDataController(SensorDataService service) {
        this.service = service;
    }

    @PostMapping("/sensor")
    public ResponseEntity<SensorData> ingestData(@RequestBody SensorData data) {
        return ResponseEntity.ok(service.ingest(data));
    }
}
