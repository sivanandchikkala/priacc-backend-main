package com.disaster.core.controller;

import com.disaster.core.entity.Sensor;
import com.disaster.core.service.SensorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sensors")
public class SensorController {
    private final SensorService service;

    public SensorController(SensorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Sensor>> all() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Sensor> add(@RequestBody Sensor sensor) {
        return ResponseEntity.ok(service.add(sensor));
    }
}
