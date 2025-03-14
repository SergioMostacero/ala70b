package com.example.demo.controller;

import com.example.demo.DTO.RangoDTO;
import com.example.demo.services.RangoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rangos")
@CrossOrigin(origins = "*")
public class RangoController {

    @Autowired
    private RangoService rangoService;

    @GetMapping
    public ResponseEntity<List<RangoDTO>> getAllRangos() {
        return ResponseEntity.ok(rangoService.getAllRangos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RangoDTO> getRangoById(@PathVariable Long id) {
        return ResponseEntity.ok(rangoService.getRangoById(id));
    }

    @PostMapping
    public ResponseEntity<RangoDTO> createRango(@RequestBody RangoDTO rangoDTO) {
        return ResponseEntity.ok(rangoService.createRango(rangoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RangoDTO> updateRango(@PathVariable Long id, @RequestBody RangoDTO rangoDTO) {
        return ResponseEntity.ok(rangoService.updateRango(id, rangoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRango(@PathVariable Long id) {
        rangoService.deleteRango(id);
        return ResponseEntity.ok().build();
    }
} 