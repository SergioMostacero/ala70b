package com.example.demo.services;

import com.example.demo.DTO.ItinerarioDTO;
import com.example.demo.DTO.ItinerarioUbicacionDTO;
import com.example.demo.mapper.ItinerarioMapper.ItinerarioMapper;
import com.example.demo.model.Itinerario;
import com.example.demo.model.ItinerarioUbicacion;
import com.example.demo.model.Ubicacion;
import com.example.demo.repository.ItinerarioRepository;
import com.example.demo.repository.ItinerarioUbicacionRepository;
import com.example.demo.repository.UbicacionRepository;
import com.example.demo.mapper.UbicacionMapper.UbicacionMapper;
import com.example.demo.mapper.UbicacionMapper.UbicacionMapperImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItinerarioService {

    @Autowired
    private ItinerarioRepository itinerarioRepository;

    @Autowired
    private ItinerarioUbicacionRepository iuRepo;

    @Autowired
    private UbicacionMapper ubicacionMapper;
    @Autowired
    private UbicacionRepository ubicacionRepository;

    @Autowired
    private ItinerarioMapper mapper;

    public List<ItinerarioDTO> getAll() {
        List<Itinerario> entidades = itinerarioRepository.findAll();
        return mapper.toListDTO(entidades);
    }

    public ItinerarioDTO getById(Long id) {
        Itinerario entidad = itinerarioRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Itinerario no encontrado con id: " + id
            ));
        entidad.setItinerarioUbicaciones(
            entidad.getItinerarioUbicaciones().stream()
                   .sorted(Comparator.comparing(ItinerarioUbicacion::getOrden))
                   .collect(Collectors.toList())
        );
        return mapper.toDTO(entidad);
    }

    public ItinerarioDTO create(ItinerarioDTO dto) {
        // 1) Ordenar las ubicaciones entrantes
        List<ItinerarioUbicacionDTO> ubicDtos = dto.getItinerarioUbicacionDTO()
            .stream()
            .sorted(Comparator.comparing(ItinerarioUbicacionDTO::getOrden))
            .collect(Collectors.toList());
    
        // 2) Obtener todas las ubicaciones y extraer nombres de ciudades
        List<Ubicacion> ubicaciones = ubicDtos.stream()
            .map(iuDto -> ubicacionRepository.findById(iuDto.getUbicacionDTO().getId())
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Ubicación no encontrada con id: " + iuDto.getUbicacionDTO().getId()
                )))
            .collect(Collectors.toList());
    
        // 3) Construir nombre = "Ciudad1 → Ciudad2 → ..."
        String ruta = ubicaciones.stream()
            .map(ub -> {
                String[] partes = ub.getCiudad().split("/");
                return partes[partes.length - 1];
            })
            .collect(Collectors.joining(" → "));
        dto.setNombre(ruta);
    
        // 4) Crear la entidad padre (sin hijos aún)
        Itinerario it = new Itinerario();
        it.setNombre(dto.getNombre());
        it.setDuracion(dto.getDuracion());
        Itinerario guardado = itinerarioRepository.save(it);
    
        // 5) Persistir cada enlace en la tabla intermedia
        List<ItinerarioUbicacion> enlaces = ubicDtos.stream()
            .map(iuDto -> {
                Ubicacion ub = ubicaciones.get(ubicDtos.indexOf(iuDto));
                ItinerarioUbicacion iu = new ItinerarioUbicacion();
                iu.setItinerario(guardado);
                iu.setUbicacion(ub);
                iu.setOrden(iuDto.getOrden());
                return iuRepo.save(iu);
            })
            .collect(Collectors.toList());
    
        // 6) Asociar enlaces al itinerario y devolver DTO
        guardado.setItinerarioUbicaciones(enlaces);
        return mapper.toDTO(guardado);
    }

    public ItinerarioDTO update(Long id, ItinerarioDTO dto) {
        if (!itinerarioRepository.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Itinerario no encontrado con id: " + id
            );
        }
        // Borrar vínculos previos
        iuRepo.deleteAll(iuRepo.findAllByItinerarioId(id));
        // Reutilizar create para reconstruir
        dto.setId(id);
        return create(dto);
    }

    public void delete(Long id) {
        if (!itinerarioRepository.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Itinerario no encontrado con id: " + id
            );
        }
        // primero borrar enlaces
        iuRepo.deleteAll(iuRepo.findAllByItinerarioId(id));
        // luego el itinerario
        itinerarioRepository.deleteById(id);
    }
}
