package com.disaster.ai.service;

import com.disaster.ai.dto.PredictionRequest;
import com.disaster.ai.dto.PredictionResponse;
import com.disaster.ai.entity.PredictionRecord;
import com.disaster.ai.repository.PredictionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PredictionService {

    private final WebClient.Builder webClientBuilder;
    private final PredictionRepository repo;

    @Value("${python.model-url}")
    private String pythonModelUrl;

    public PredictionService(WebClient.Builder webClientBuilder, PredictionRepository repo) {
        this.webClientBuilder = webClientBuilder;
        this.repo = repo;
    }

    public PredictionResponse getPrediction(PredictionRequest request) {
        // Call the  ML model API 
        Double riskScore = webClientBuilder.build()
                .post()
                .uri(pythonModelUrl)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Double.class)
                .onErrorResume(e -> Mono.just(-1.0))
                .block();

        // Save result
        PredictionRecord record = PredictionRecord.builder()
                .model(request.getModel())
                .inputPayload(request.toString())
                .riskScore(riskScore)
                .build();

        repo.save(record);

        return new PredictionResponse(riskScore, "Prediction processed successfully");
    }
}
