package com.disaster.ai.controller;

import com.disaster.ai.dto.PredictionRequest;
import com.disaster.ai.dto.PredictionResponse;
import com.disaster.ai.service.PredictionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ai")
public class PredictionController {

    private final PredictionService service;

    public PredictionController(PredictionService service) {
        this.service = service;
    }

    @PostMapping("/predict")
    public ResponseEntity<PredictionResponse> predict(@RequestBody PredictionRequest request) {
        return ResponseEntity.ok(service.getPrediction(request));
    }
}
