package com.example.demo.controller;

import com.example.demo.DTO.GrupoSanguineoDTO;
import com.example.demo.services.GrupoSanguineoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/grupoSanguineos")
@CrossOrigin(origins = "*")
public class GrupoSanguineoController {

    @Autowired
    private GrupoSanguineoService grupoSanguineoService;

    @GetMapping
    public ResponseEntity<List<GrupoSanguineoDTO>> getAllGruposSanguineos() {
        List<GrupoSanguineoDTO> dtos = grupoSanguineoService.getAll();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoSanguineoDTO> getGrupoSanguineoById(@PathVariable Long id) {
        GrupoSanguineoDTO dto = grupoSanguineoService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<GrupoSanguineoDTO> createGrupoSanguineo(@RequestBody GrupoSanguineoDTO dto) {
        GrupoSanguineoDTO created = grupoSanguineoService.create(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrupoSanguineoDTO> updateGrupoSanguineo(
            @PathVariable Long id,
            @RequestBody GrupoSanguineoDTO dto
    ) {
        dto.setId(id);
        GrupoSanguineoDTO updated = grupoSanguineoService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrupoSanguineo(@PathVariable Long id) {
        grupoSanguineoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
