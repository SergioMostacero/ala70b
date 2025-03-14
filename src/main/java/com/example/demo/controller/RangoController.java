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

import com.example.demo.model.Rango;
import com.example.demo.services.RangoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/rango")
@CrossOrigin
public class RangoController {
    
    @Autowired
    private RangoService rangoService;

    @GetMapping
    public ResponseEntity<List<Rango>> getAllRangos() {
        try {
            List<Rango> rangos = rangoService.getRangos();
            return ResponseEntity.ok(rangos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rango> getRangoById(@PathVariable Long id) {
        try {
            Rango rango = rangoService.getRangoById(id);
            return ResponseEntity.ok(rango);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRangoById(@PathVariable Long id) {
        try {
            rangoService.deleteRangoById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Rango> createRango(@RequestBody Rango rango) {
        try {
            Rango createdRango = rangoService.createRango(rango);
            return ResponseEntity.ok(createdRango);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PatchMapping("/{id}/name")
    public ResponseEntity<Rango> updateRangoName(@PathVariable Long id, @RequestBody String newName) {
        try {
            Rango rango = rangoService.updateRangoName(id, newName);
            return ResponseEntity.ok(rango);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DeleteMapping("/deleterango/{rangoId}")
    public ResponseEntity<Rango> deleteRangoAdmin(@PathVariable Long rangoId, @RequestParam Long roleId) {
        try {
            Rango deletedRango = rangoService.deleteRangoAdmin(rangoId, roleId);
            return ResponseEntity.ok(deletedRango);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
