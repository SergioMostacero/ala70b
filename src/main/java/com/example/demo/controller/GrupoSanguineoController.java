package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.DTO.GrupoSanguineoDTO;
import com.example.demo.services.GrupoSanguineoService;

@RestController
@RequestMapping("/api/grupoSanguineos")
@CrossOrigin(origins = "*")
public class GrupoSanguineoController {

    @Autowired
    private GrupoSanguineoService grupoSanguineoService;

    @GetMapping
    public ResponseEntity<List<GrupoSanguineoDTO>> getAllGrupoSanguineos() {
        return ResponseEntity.ok(grupoSanguineoService.getAllGrupoSanguineos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoSanguineoDTO> getGrupoSanguineoById(@PathVariable Long id) {
        return ResponseEntity.ok(grupoSanguineoService.getGrupoSanguineoById(id));
    }

    @PostMapping
    public ResponseEntity<GrupoSanguineoDTO> createGrupoSanguineo(@RequestBody GrupoSanguineoDTO grupoSanguineoDTO) {
        return ResponseEntity.ok(grupoSanguineoService.createGrupoSanguineo(grupoSanguineoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrupoSanguineoDTO> updateGrupoSanguineo(@PathVariable Long id, @RequestBody GrupoSanguineoDTO grupoSanguineoDTO) {
        return ResponseEntity.ok(grupoSanguineoService.updateGrupoSanguineo(id, grupoSanguineoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrupoSanguineo(@PathVariable Long id) {
        grupoSanguineoService.deleteGrupoSanguineo(id);
        return ResponseEntity.ok().build();
    }
} 