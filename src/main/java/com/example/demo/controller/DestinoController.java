package com.example.demo.controller;

import com.example.demo.DTO.DestinoDTO;
import com.example.demo.services.DestinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinos")
@CrossOrigin(origins = "*")
public class DestinoController {

    @Autowired
    private DestinoService destinoService;

    @GetMapping
    public ResponseEntity<List<DestinoDTO>> getAllDestinos() {
        return ResponseEntity.ok(destinoService.getAllDestinos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DestinoDTO> getDestinoById(@PathVariable Long id) {
        return ResponseEntity.ok(destinoService.getDestinoById(id));
    }

    @PostMapping
    public ResponseEntity<DestinoDTO> createDestino(@RequestBody DestinoDTO destinoDTO) {
        return ResponseEntity.ok(destinoService.createDestino(destinoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DestinoDTO> updateDestino(@PathVariable Long id, @RequestBody DestinoDTO destinoDTO) {
        return ResponseEntity.ok(destinoService.updateDestino(id, destinoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDestino(@PathVariable Long id) {
        destinoService.deleteDestino(id);
        return ResponseEntity.ok().build();
    }
} 