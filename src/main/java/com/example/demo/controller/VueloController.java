package com.example.demo.controller;

import com.example.demo.DTO.VueloDTO;
import com.example.demo.services.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vuelos")
@CrossOrigin(origins = "*")
public class VueloController {

    @Autowired
    private VueloService vueloService;

    @GetMapping
    public ResponseEntity<List<VueloDTO>> getAllVuelos() {
        return ResponseEntity.ok(vueloService.getAllVuelos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VueloDTO> getVueloById(@PathVariable Long id) {
        return ResponseEntity.ok(vueloService.getVueloById(id));
    }

    @PostMapping
    public ResponseEntity<VueloDTO> createVuelo(@RequestBody VueloDTO vueloDTO) {
        return ResponseEntity.ok(vueloService.createVuelo(vueloDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VueloDTO> updateVuelo(@PathVariable Long id, @RequestBody VueloDTO vueloDTO) {
        return ResponseEntity.ok(vueloService.updateVuelo(id, vueloDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVuelo(@PathVariable Long id) {
        vueloService.deleteVuelo(id);
        return ResponseEntity.ok().build();
    }
} 