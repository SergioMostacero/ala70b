package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.VueloDTO;
import com.example.demo.services.VueloService;

@RestController
@RequestMapping("/api/vuelos")
@CrossOrigin(origins = "*")
public class VueloController {

    @Autowired
    private VueloService vueloService;

    @GetMapping
    public ResponseEntity<List<VueloDTO>> getAllVuelos() {
        List<VueloDTO> vuelos = vueloService.getAllVuelos();
        return ResponseEntity.ok(vuelos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VueloDTO> getVueloById(@PathVariable Long id) {
        VueloDTO vueloDTO = vueloService.getVueloById(id);
        return ResponseEntity.ok(vueloDTO);
    }

    @PostMapping
    public ResponseEntity<VueloDTO> createVuelo(@RequestBody VueloDTO vueloDto) {
        VueloDTO created = vueloService.createVuelo(vueloDto);
        // Devolvemos 201 (Created) en lugar de 200 (OK)
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VueloDTO> updateVuelo(@PathVariable Long id, @RequestBody VueloDTO vueloDTO) {
        VueloDTO updated = vueloService.updateVuelo(id, vueloDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVuelo(@PathVariable Long id) {
        vueloService.deleteVuelo(id);
        return ResponseEntity.ok().build();
    }
}
