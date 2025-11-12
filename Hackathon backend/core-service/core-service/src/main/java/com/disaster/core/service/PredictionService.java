package com.disaster.core.service;

import com.disaster.core.entity.Prediction;
import com.disaster.core.repository.PredictionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PredictionService {
    private final PredictionRepository repo;

    public PredictionService(PredictionRepository repo) {
        this.repo = repo;
    }

    public Prediction save(Prediction p) { return repo.save(p); }
    public List<Prediction> getAll() { return repo.findAll(); }
}
