package com.disaster.core.service;

import com.disaster.core.entity.Sensor;
import com.disaster.core.repository.SensorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SensorService {
    private final SensorRepository repo;

    public SensorService(SensorRepository repo) {
        this.repo = repo;
    }

    public List<Sensor> getAll() { return repo.findAll(); }
    public Sensor add(Sensor s) { return repo.save(s); }
}
