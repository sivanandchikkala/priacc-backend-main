package com.disaster.core.controller;

import com.disaster.core.entity.Incident;
import com.disaster.core.service.IncidentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/incidents")
public class IncidentController {
    private final IncidentService service;

    public IncidentController(IncidentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Incident>> all() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Incident> add(@RequestBody Incident incident) {
        return ResponseEntity.ok(service.add(incident));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Incident> update(@PathVariable Long id, @RequestBody Incident incident) {
        return ResponseEntity.ok(service.update(id, incident));
    }
}
