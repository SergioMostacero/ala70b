package com.example.demo.controller;

import com.example.demo.DTO.OficioDTO;
import com.example.demo.services.OficioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/oficios")
@CrossOrigin(origins = "*")
public class OficioController {

    @Autowired
    private OficioService oficioService;

    @GetMapping
    public ResponseEntity<List<OficioDTO>> getAllOficios() {
        List<OficioDTO> dtos = oficioService.getAll();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OficioDTO> getOficioById(@PathVariable Long id) {
        OficioDTO dto = oficioService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<OficioDTO> createOficio(@RequestBody OficioDTO dto) {
        OficioDTO created = oficioService.create(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OficioDTO> updateOficio(
            @PathVariable Long id,
            @RequestBody OficioDTO dto
    ) {
        dto.setId(id);
        OficioDTO updated = oficioService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOficio(@PathVariable Long id) {
        oficioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
