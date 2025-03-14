package com.example.demo.services;

import com.example.demo.DTO.DestinoDTO;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Destino;
import com.example.demo.repository.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinoService {

    @Autowired
    private DestinoRepository destinoRepository;

    public List<DestinoDTO> getAllDestinos() {
        return destinoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public DestinoDTO getDestinoById(Long id) {
        return destinoRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Destino no encontrado con id: " + id));
    }

    public DestinoDTO createDestino(DestinoDTO destinoDTO) {
        Destino destino = convertToEntity(destinoDTO);
        return convertToDTO(destinoRepository.save(destino));
    }

    public DestinoDTO updateDestino(Long id, DestinoDTO destinoDTO) {
        if (destinoDTO == null) {
            throw new IllegalArgumentException("El DTO del destino no puede ser nulo");
        }
        
        Destino destino = destinoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Destino no encontrado con id: " + id));
        
        updateDestinoFields(destino, destinoDTO);
        return convertToDTO(destinoRepository.save(destino));
    }

    private void updateDestinoFields(Destino destino, DestinoDTO dto) {
        destino.setNombre(dto.getNombre());
        destino.setDescripcion(dto.getDescripcion());
        destino.setImagenURL(dto.getImagenURL());
    }

    public void deleteDestino(Long id) {
        destinoRepository.deleteById(id);
    }

    private DestinoDTO convertToDTO(Destino destino) {
        DestinoDTO dto = new DestinoDTO();
        dto.setId(destino.getId());
        dto.setNombre(destino.getNombre());
        dto.setDescripcion(destino.getDescripcion());
        dto.setImagenURL(destino.getImagenURL());
        return dto;
    }

    private Destino convertToEntity(DestinoDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("El DTO no puede ser nulo");
        }
        
        Destino destino = new Destino();
        destino.setId(dto.getId());
        destino.setNombre(dto.getNombre());
        destino.setDescripcion(dto.getDescripcion());
        destino.setImagenURL(dto.getImagenURL());
        return destino;
    }
}