package com.example.demo.controller;

import com.example.demo.model.Avion;
import com.example.demo.services.AvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aviones")
@CrossOrigin(origins = "*")
public class AvionController {

    @Autowired
    private AvionService avionService;

    @GetMapping
    public ResponseEntity<List<Avion>> getAllAviones() {
        return ResponseEntity.ok(avionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avion> getAvionById(@PathVariable Long id) {
        return ResponseEntity.ok(avionService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Avion> createAvion(@RequestBody Avion avion) {
        return ResponseEntity.ok(avionService.create(avion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Avion> updateAvion(@PathVariable Long id, @RequestBody Avion avion) {
        avion.setId(id);
        return ResponseEntity.ok(avionService.update(avion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvion(@PathVariable Long id) {
        avionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
