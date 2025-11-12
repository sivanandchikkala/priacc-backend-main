package com.disaster.core.controller;

import com.disaster.core.entity.Prediction;
import com.disaster.core.service.PredictionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/predictions")
public class PredictionController {
    private final PredictionService service;

    public PredictionController(PredictionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Prediction>> all() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Prediction> add(@RequestBody Prediction prediction) {
        return ResponseEntity.ok(service.save(prediction));
    }
}
