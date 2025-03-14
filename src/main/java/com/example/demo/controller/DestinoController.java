package com.example.demo.controller;

import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Destino;
import com.example.demo.services.DestinoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/destino")
@CrossOrigin
public class DestinoController {
    
    @Autowired
    private DestinoService destinoService;

    @GetMapping
    public ResponseEntity<List<Destino>> getAllDestinos() {
        try {
            List<Destino> destinos = destinoService.getDestinos();
            return ResponseEntity.ok(destinos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destino> getDestinoById(@PathVariable Long id) {
        try {
            Destino destino = destinoService.getDestinoById(id);
            return ResponseEntity.ok(destino);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDestinoById(@PathVariable Long id) {
        try {
            destinoService.deleteDestinoById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Destino> createDestino(@RequestBody Destino destino) {
        try {
            Destino createdDestino = destinoService.createDestino(destino);
            return ResponseEntity.ok(createdDestino);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PatchMapping("/{id}/name")
    public ResponseEntity<Destino> updateDestinoName(@PathVariable Long id, @RequestBody String newName) {
        try {
            Destino destino = destinoService.updateDestinoName(id, newName);
            return ResponseEntity.ok(destino);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DeleteMapping("/deletedestino/{destinoId}")
    public ResponseEntity<Destino> deleteDestinoAdmin(@PathVariable Long destinoId, @RequestParam Long roleId) {
        try {
            Destino deletedDestino = destinoService.deleteDestinoAdmin(destinoId, roleId);
            return ResponseEntity.ok(deletedDestino);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
