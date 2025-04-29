package com.example.demo.controller;

import com.example.demo.DTO.TripulantesDTO;
import com.example.demo.services.TripulantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tripulantes")
@CrossOrigin(origins = "http://localhost:4200")
public class TripulantesController {

    @Autowired
    private TripulantesService tripulantesService;

    @GetMapping
    public ResponseEntity<List<TripulantesDTO>> getAllTripulantes() {
        List<TripulantesDTO> dtos = tripulantesService.getAll();
        return ResponseEntity.ok(dtos);
    }

    @PostMapping("/login")
    public ResponseEntity<TripulantesDTO> login(@RequestBody Map<String, String> credenciales) {
        TripulantesDTO dto = tripulantesService.login(
            credenciales.get("email"),
            credenciales.get("contrasena")
        );
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripulantesDTO> getTripulanteById(@PathVariable Long id) {
        TripulantesDTO dto = tripulantesService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/pilotos")
    public ResponseEntity<List<TripulantesDTO>> getPilotos() {
        List<TripulantesDTO> pilotos = tripulantesService.getAll().stream()
            .filter(t -> "Piloto".equalsIgnoreCase(t.getOficioDTO().getNombre()))
            .collect(Collectors.toList());
        return ResponseEntity.ok(pilotos);
    }

    @GetMapping("/copilotos")
    public ResponseEntity<List<TripulantesDTO>> getCopilotos() {
        List<TripulantesDTO> copilotos = tripulantesService.getAll().stream()
            .filter(t -> "Copiloto".equalsIgnoreCase(t.getOficioDTO().getNombre()))
            .collect(Collectors.toList());
        return ResponseEntity.ok(copilotos);
    }

    @GetMapping("/mecanicos")
    public ResponseEntity<List<TripulantesDTO>> getMecanicos() {
        List<TripulantesDTO> mecanicos = tripulantesService.getAll().stream()
            .filter(t -> "Mecánico de Aeronaves".equalsIgnoreCase(t.getOficioDTO().getNombre()))
            .collect(Collectors.toList());
        return ResponseEntity.ok(mecanicos);
    }

    @GetMapping("/tecnicoscom")
    public ResponseEntity<List<TripulantesDTO>> getTecnicosCom() {
        List<TripulantesDTO> tecnicos = tripulantesService.getAll().stream()
            .filter(t -> "Técnico de Comunicaciones y Navegación".equalsIgnoreCase(t.getOficioDTO().getNombre()))
            .collect(Collectors.toList());
        return ResponseEntity.ok(tecnicos);
    }

    @PostMapping
    public ResponseEntity<TripulantesDTO> createTripulante(@RequestBody TripulantesDTO dto) {
        TripulantesDTO created = tripulantesService.createTripulantes(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    // En MedallaController.java
        @PutMapping("/asignar-medalla/{tripulanteId}/{medallaId}")
        public ResponseEntity<String> asignarMedalla(@PathVariable Long tripulanteId, @PathVariable Long medallaId) {
            tripulantesService.asignarMedalla(tripulanteId, medallaId);
            return ResponseEntity.ok("Medalla asignada correctamente");
        }


    @PutMapping("/{id}")
    public ResponseEntity<TripulantesDTO> updateTripulante(
            @PathVariable Long id,
            @RequestBody TripulantesDTO dto
    ) {
        TripulantesDTO updated = tripulantesService.updateName(id, dto.getNombre());
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTripulante(@PathVariable Long id) {
        tripulantesService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
