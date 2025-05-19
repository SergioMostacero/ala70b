package com.example.demo.controller;

import com.example.demo.DTO.MedallaDTO;
import com.example.demo.services.MedallaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/medallas")
@CrossOrigin(origins = "*")
public class MedallaController {

    @Autowired
    private MedallaService medallaService;

    @GetMapping
    public ResponseEntity<List<MedallaDTO>> getAllMedallas() {
        List<MedallaDTO> dtos = medallaService.getAllMedallas();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/tripulante/{tripulanteId}")
    public ResponseEntity<List<MedallaDTO>> getMedallasByTripulante(
            @PathVariable Long tripulanteId
    ) {
        List<MedallaDTO> dtos = medallaService.getMedallasByTripulante(tripulanteId);
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<MedallaDTO> createMedalla(@RequestBody MedallaDTO dto) {
        MedallaDTO created = medallaService.createMedalla(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/asignar-medalla/{tripulanteId}/{medallaId}")
    public ResponseEntity<String> asignarMedalla(@PathVariable Long tripulanteId, @PathVariable Long medallaId) {
        medallaService.asignarMedalla(tripulanteId, medallaId);
        return ResponseEntity.ok("Medalla asignada correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedalla(@PathVariable Long id) {
        medallaService.deleteMedalla(id);
        return ResponseEntity.noContent().build();
    }

}
