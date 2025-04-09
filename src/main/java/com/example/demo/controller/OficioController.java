package com.example.demo.controller;

import com.example.demo.DTO.OficioDTO;
import com.example.demo.services.OficioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/oficios")
@CrossOrigin(origins = "*")
public class OficioController {

    @Autowired
    private OficioService OficioService;

    @GetMapping
    public ResponseEntity<List<OficioDTO>> getAllOficios() {
        return ResponseEntity.ok(OficioService.getAllOficios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OficioDTO> getOficioById(@PathVariable Long id) {
        return ResponseEntity.ok(OficioService.getOficioById(id));
    }

    @PostMapping
    public ResponseEntity<OficioDTO> createOficio(@RequestBody OficioDTO OficioDTO) {
        return ResponseEntity.ok(OficioService.createOficio(OficioDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OficioDTO> updateOficio(@PathVariable Long id, @RequestBody OficioDTO OficioDTO) {
        return ResponseEntity.ok(OficioService.updateOficio(id, OficioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOficio(@PathVariable Long id) {
        OficioService.deleteOficio(id);
        return ResponseEntity.ok().build();
    }
} 