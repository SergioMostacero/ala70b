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

import com.example.demo.model.Tripulantes;
import com.example.demo.services.TripulantesService;

@RestController
@RequestMapping("/api/Tripulantess")
@CrossOrigin(origins = "*")
public class TripulantesController {

    @Autowired
    private TripulantesService TripulantesService;

    @GetMapping
    public List<Tripulantes> getAllTripulantess() {
        return TripulantesService.getTripulantess();
    }

    // @PostMapping("/login")
    // public ResponseEntity<Tripulantes> login(@RequestBody LoginRequest loginRequest) {
    //     Tripulantes Tripulantes = TripulantesService.login(loginRequest.getEmail(), loginRequest.getContrasena());
    //     return ResponseEntity.ok(Tripulantes);
    // }



    @GetMapping("/{id}")
    public Tripulantes getTripulantesById(@PathVariable Long id) {
        return TripulantesService.getTripulantesById(id);
    }

    @PostMapping
    public Tripulantes createTripulantes(@RequestBody Tripulantes Tripulantes) {
        return TripulantesService.createTripulantes(Tripulantes);
    }

    @PutMapping("/{id}")
    public Tripulantes updateTripulantes(@PathVariable Long id, @RequestBody Tripulantes Tripulantes) {
        return TripulantesService.updateTripulantesName(id, Tripulantes.getNombre());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTripulantes(@PathVariable Long id) {
        TripulantesService.deleteTripulantesById(id);
        return ResponseEntity.ok().build();
    }
} 