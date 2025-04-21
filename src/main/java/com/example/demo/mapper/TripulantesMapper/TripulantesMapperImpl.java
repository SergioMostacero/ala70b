package com.example.demo.mapper.TripulantesMapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.TripulantesDTO;
import com.example.demo.mapper.GrupoSanguineoMapper.GrupoSanguineoMapper;
import com.example.demo.mapper.MedallaMapper.MedallaMapper;
import com.example.demo.mapper.OficioMapper.OficioMapper;
import com.example.demo.mapper.RangoMapper.RangoMapper;
import com.example.demo.mapper.VueloMapper.VueloMapper;
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
        dto.setAntiguedad(tripulante.getAntiguedad().toLocalDate());
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
    public List<TripulantesDTO> toListDTO(List<Tripulantes> tripulantess) {
        return tripulantess.stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }
}