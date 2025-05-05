package com.example.demo.controller;

import com.example.demo.DTO.UbicacionDTO;
import com.example.demo.services.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/ubicaciones")
@CrossOrigin(origins = "*")
public class UbicacionController {

    @Autowired
    private UbicacionService ubicacionService;

    @GetMapping
    public ResponseEntity<List<UbicacionDTO>> getAllUbicaciones() {
        List<UbicacionDTO> dtos = ubicacionService.getAll();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UbicacionDTO> getUbicacionById(@PathVariable int id) {
        UbicacionDTO dto = ubicacionService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<UbicacionDTO> createUbicacion(@RequestBody UbicacionDTO dto) {
        UbicacionDTO created = ubicacionService.create(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UbicacionDTO> updateUbicacion(
            @PathVariable int id,
            @RequestBody UbicacionDTO dto
    ) {
        UbicacionDTO updated = ubicacionService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUbicacion(@PathVariable int id) {
        ubicacionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/itinerario/{itinerarioId}")
    public ResponseEntity<List<UbicacionDTO>> getByItinerario(
            @PathVariable Long itinerarioId
    ) {
        List<UbicacionDTO> dtos = ubicacionService.getByItinerario(itinerarioId);
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/tripulante/{tripulanteId}")
    public ResponseEntity<List<UbicacionDTO>> getUbicacionesPorTripulante(
        @PathVariable Long tripulanteId
    ) {
        List<UbicacionDTO> ubicaciones = ubicacionService.getByTripulante(tripulanteId);
        return ResponseEntity.ok(ubicaciones);
    }
}
