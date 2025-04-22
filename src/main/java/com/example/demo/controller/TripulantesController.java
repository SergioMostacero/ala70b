package com.example.demo.controller;

import java.util.List;
import java.util.Map;

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

import com.example.demo.model.Tripulantes;
import com.example.demo.services.TripulantesService;
import com.example.demo.repository.TripulantesRepository;

@RestController
@RequestMapping("/api/tripulantes")
@CrossOrigin(origins = "http://localhost:4200")
public class TripulantesController {

    @Autowired
    private TripulantesService tripulantesService;
    @Autowired
    private TripulantesRepository tripulanteRepository;

    @GetMapping
    public List<Tripulantes> getAllTripulantess() {
        return tripulantesService.getTripulantes();
    }

    @PostMapping("/login")
    public ResponseEntity<Tripulantes> login(@RequestBody Map<String, String> credenciales) {
        Tripulantes usuarioAutenticado = tripulantesService.login(
            credenciales.get("email"), 
            credenciales.get("contrasena")
        );
        return ResponseEntity.ok(usuarioAutenticado);
    }




    @GetMapping("/{id}")
    public Tripulantes getTripulantesById(@PathVariable Long id) {
        return tripulantesService.getTripulantesById(id);
    }
    @GetMapping("/pilotos")
    public List<Tripulantes> getPilotos() {
        return tripulanteRepository.findByOficioNombreIgnoreCase("Piloto");
    }
    
    @GetMapping("/copilotos")
    public List<Tripulantes> getCopilotos() {
        return tripulanteRepository.findByOficioNombreIgnoreCase("Copiloto");
    }
    
    @GetMapping("/mecanicos")
    public List<Tripulantes> getMecanicos() {
        return tripulanteRepository.findByOficioNombreIgnoreCase("Mecánico de Aeronaves");
    }
    
    @GetMapping("/tecnicoscom")
    public List<Tripulantes> getTecnicosCom() {
        return tripulanteRepository.findByOficioNombreIgnoreCase("Técnico de Comunicaciones y Navegación");
    }

    @PostMapping
    public Tripulantes createTripulantes(@RequestBody Tripulantes tripulantes) {
        return tripulantesService.createTripulantes(tripulantes);
    }

    @PutMapping("/{id}")
    public Tripulantes updateTripulantes(@PathVariable Long id, @RequestBody Tripulantes tripulantes) {
        return tripulantesService.updateTripulantesName(id, tripulantes.getNombre());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTripulantes(@PathVariable Long id) {
        tripulantesService.deleteTripulantesById(id);
        return ResponseEntity.ok().build();
    }
} 