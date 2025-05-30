package com.example.demo.mapper.TripulantesMapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.AvionDTO;
import com.example.demo.DTO.TripulantesDTO;
import com.example.demo.mapper.GrupoSanguineoMapper.GrupoSanguineoMapper;
import com.example.demo.mapper.MedallaMapper.MedallaMapper;
import com.example.demo.mapper.OficioMapper.OficioMapper;
import com.example.demo.mapper.RangoMapper.RangoMapper;
import com.example.demo.mapper.VueloMapper.VueloMapper;
import com.example.demo.model.Avion;
import com.example.demo.model.Tripulantes;

@Component
public class TripulantesMapperImpl implements TripulantesMapper {

    @Autowired private RangoMapper rangoMapper;
    @Autowired private GrupoSanguineoMapper grupoSanguineoMapper;
    @Autowired private OficioMapper oficioMapper;
    @Autowired private MedallaMapper medallaMapper;
    @Autowired private VueloMapper vueloMapper;

    @Override
    public TripulantesDTO toDTO(Tripulantes tripulante) {
        TripulantesDTO dto = new TripulantesDTO();
        
        dto.setId(tripulante.getId());
        dto.setNombre(tripulante.getNombre());
        dto.setApellidos(tripulante.getApellidos());
        dto.setEmail(tripulante.getEmail());
        dto.setContrasena(tripulante.getContrasena());
        dto.setAntiguedad(tripulante.getAntiguedad());
        dto.setPermisos(tripulante.getPermisos());
        dto.setHoras_totales(tripulante.getHoras_totales());
        
        // Mapeo de relaciones
        dto.setRangoDTO(rangoMapper.toDTO(tripulante.getRango()));
        dto.setGrupoSanguineoDTO(grupoSanguineoMapper.toDTO(tripulante.getGrupoSanguineo()));
        dto.setOficioDTO(oficioMapper.toDTO(tripulante.getOficio()));
        
        // Mapeo de listas
        dto.setMedallasDTO(
            tripulante.getMedallas().stream()
                .map(medallaMapper::toDTO)
                .collect(Collectors.toList())
        );
        
        dto.setVuelosDTO(
            tripulante.getVuelos().stream()
                .map(vueloMapper::toDTO)
                .collect(Collectors.toList())
        );

        return dto;
    }

    @Override
    public Tripulantes toEntity(TripulantesDTO dto) {
        if (dto == null) {
            return null;
        }

        Tripulantes tripulantes = new Tripulantes();

        tripulantes.setId(dto.getId());           
        tripulantes.setNombre(dto.getNombre());
        tripulantes.setApellidos(dto.getApellidos());
        tripulantes.setEmail(dto.getEmail());
        tripulantes.setContrasena(dto.getContrasena());
        tripulantes.setAntiguedad(dto.getAntiguedad());
        tripulantes.setPermisos(dto.getPermisos());
        tripulantes.setHoras_totales(dto.getHoras_totales());

        tripulantes.setRango(
            dto.getRangoDTO() != null
                ? rangoMapper.toEntity(dto.getRangoDTO())
                : null
        );

        tripulantes.setGrupoSanguineo(
            dto.getGrupoSanguineoDTO() != null
                ? grupoSanguineoMapper.toEntity(dto.getGrupoSanguineoDTO())
                : null
        );

        tripulantes.setOficio(
            dto.getOficioDTO() != null
                ? oficioMapper.toEntity(dto.getOficioDTO())
                : null
        );

        // ────────── Listas ──────────
        tripulantes.setMedallas(
            dto.getMedallasDTO() != null
                ? dto.getMedallasDTO().stream()
                    .map(medallaMapper::toEntity)
                    .collect(Collectors.toList())
                : List.of()                                    // Java 9+, usa new ArrayList<>() si estás en 8
        );

        tripulantes.setVuelos(
            dto.getVuelosDTO() != null
                ? dto.getVuelosDTO().stream()
                    .map(vueloMapper::toEntity)
                    .collect(Collectors.toList())
                : List.of()
        );

        return tripulantes;
    }


    @Override
    public List<TripulantesDTO> toListDTO(List<Tripulantes> tripulantess) {
        return tripulantess.stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }
}