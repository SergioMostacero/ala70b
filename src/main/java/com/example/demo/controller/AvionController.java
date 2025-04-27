package com.example.demo.controller;

import com.example.demo.DTO.AvionDTO;
import com.example.demo.services.AvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/aviones")
@CrossOrigin(origins = "*")
public class AvionController {

    @Autowired
    private AvionService avionService;

    @GetMapping
    public ResponseEntity<List<AvionDTO>> getAllAviones() {
        List<AvionDTO> dtos = avionService.getAll();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvionDTO> getAvionById(@PathVariable Long id) {
        AvionDTO dto = avionService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<AvionDTO> createAvion(@RequestBody AvionDTO dto) {
        AvionDTO created = avionService.createAvion(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvionDTO> updateAvion(
            @PathVariable Long id,
            @RequestBody AvionDTO dto
    ) {
        dto.setId(id);
        AvionDTO updated = avionService.updateAvion(dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvion(@PathVariable Long id) {
        avionService.deleteAvion(id);
        return ResponseEntity.noContent().build();
    }
}
