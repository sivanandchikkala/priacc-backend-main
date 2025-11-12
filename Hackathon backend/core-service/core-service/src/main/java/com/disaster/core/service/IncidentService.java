package com.disaster.core.service;

import com.disaster.core.entity.Incident;
import com.disaster.core.repository.IncidentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IncidentService {
    private final IncidentRepository repo;

    public IncidentService(IncidentRepository repo) {
        this.repo = repo;
    }

    public List<Incident> getAll() { return repo.findAll(); }

    public Incident add(Incident incident) { return repo.save(incident); }

    public Incident update(Long id, Incident updated) {
        Incident existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Incident not found"));
        existing.setStatus(updated.getStatus());
        existing.setAssignedTo(updated.getAssignedTo());
        return repo.save(existing);
    }
}
