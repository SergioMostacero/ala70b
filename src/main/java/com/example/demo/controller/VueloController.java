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

import com.example.demo.model.Vuelo;
import com.example.demo.services.VueloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/vuelo")
@CrossOrigin
public class VueloController {
    
    @Autowired
    private VueloService vueloService;

    @GetMapping
    public ResponseEntity<List<Vuelo>> getAllVuelos() {
        try {
            List<Vuelo> vuelos = vueloService.getVuelos();
            return ResponseEntity.ok(vuelos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vuelo> getVueloById(@PathVariable Long id) {
        try {
            Vuelo vuelo = vueloService.getVueloById(id);
            return ResponseEntity.ok(vuelo);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVueloById(@PathVariable Long id) {
        try {
            vueloService.deleteVueloById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Vuelo> createVuelo(@RequestBody Vuelo vuelo) {
        try {
            Vuelo createdVuelo = vueloService.createVuelo(vuelo);
            return ResponseEntity.ok(createdVuelo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PatchMapping("/{id}/name")
    public ResponseEntity<Vuelo> updateVueloName(@PathVariable Long id, @RequestBody String newName) {
        try {
            Vuelo vuelo = vueloService.updateVueloName(id, newName);
            return ResponseEntity.ok(vuelo);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DeleteMapping("/deletevuelo/{vueloId}")
    public ResponseEntity<Vuelo> deleteVueloAdmin(@PathVariable Long vueloId, @RequestParam Long roleId) {
        try {
            Vuelo deletedVuelo = vueloService.deleteVueloAdmin(vueloId, roleId);
            return ResponseEntity.ok(deletedVuelo);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
