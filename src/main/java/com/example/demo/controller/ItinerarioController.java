package com.example.demo.controller;

import com.example.demo.DTO.ItinerarioDTO;
import com.example.demo.services.ItinerarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/itinerarios")
@CrossOrigin(origins = "*")
public class ItinerarioController {

    @Autowired
    private ItinerarioService itinerarioService;

    @GetMapping
    public ResponseEntity<List<ItinerarioDTO>> getAllItinerarios() {
        List<ItinerarioDTO> dtos = itinerarioService.getAll();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItinerarioDTO> getItinerarioById(@PathVariable Long id) {
        ItinerarioDTO dto = itinerarioService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ItinerarioDTO> createItinerario(@RequestBody ItinerarioDTO dto) {
        ItinerarioDTO created = itinerarioService.create(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItinerarioDTO> updateItinerario(
            @PathVariable Long id,
            @RequestBody ItinerarioDTO dto
    ) {
        dto.setId(id);
        ItinerarioDTO updated = itinerarioService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItinerario(@PathVariable Long id) {
        itinerarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
