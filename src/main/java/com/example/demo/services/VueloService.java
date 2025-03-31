package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.VueloDTO;
import com.example.demo.model.Localizacion;
import com.example.demo.repository.VueloRepository;

@Service
public class VueloService {

    @Autowired
    private VueloRepository vueloRepository;

    public List<VueloDTO> getAllVuelos() {
        return vueloRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public VueloDTO getVueloById(Long id) {
        return vueloRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));
    }

    public VueloDTO createVuelo(VueloDTO vueloDTO) {
        Localizacion vuelo = convertToEntity(vueloDTO);
        return convertToDTO(vueloRepository.save(vuelo));
    }

    public VueloDTO updateVuelo(Long id, VueloDTO vueloDTO) {
        Localizacion vuelo = vueloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));
        vuelo.setOrigen(vueloDTO.getOrigen());
        vuelo.setDestino(vueloDTO.getDestino());
        vuelo.setFecha(vueloDTO.getFecha());
        vuelo.setDuracion(vueloDTO.getDuracion());
        vuelo.setMercancia(vueloDTO.getMercancia());
        vuelo.setModelo(vueloDTO.getModelo());
        vuelo.setUbi_salida(vueloDTO.getUbi_salida());
        vuelo.setHora_salida(vueloDTO.getHora_salida());
        vuelo.setUbi_llegada(vueloDTO.getUbi_llegada());
        vuelo.setHora_llegada(vueloDTO.getHora_llegada());
        vuelo.setHoras_mes(vueloDTO.getHoras_mes());
        vuelo.setHoras_año(vueloDTO.getHoras_año());
        vuelo.setHoras_totales(vueloDTO.getHoras_totales());
        vuelo.setAnticipo(vueloDTO.getAnticipo());
        vuelo.setLiquido(vueloDTO.getLiquido());
        vuelo.setGasolina(vueloDTO.getGasolina());
        vuelo.setHotel(vueloDTO.getHotel());
        return convertToDTO(vueloRepository.save(vuelo));
    }

    public void deleteVuelo(Long id) {
        vueloRepository.deleteById(id);
    }

    private VueloDTO convertToDTO(Localizacion vuelo) {
        VueloDTO dto = new VueloDTO();
        dto.setId(vuelo.getId());
        dto.setOrigen(vuelo.getOrigen());
        dto.setDestino(vuelo.getDestino());
        dto.setFecha(vuelo.getFecha());
        dto.setDuracion(vuelo.getDuracion());
        dto.setUsuarioId(vuelo.getUsuario().getId());
        dto.setUsuarioNombre(vuelo.getUsuario().getNombre());
        dto.setMercancia(vuelo.getMercancia());
        dto.setModelo(vuelo.getModelo());
        dto.setUbi_salida(vuelo.getUbi_salida());
        dto.setHora_salida(vuelo.getHora_salida());
        dto.setUbi_llegada(vuelo.getUbi_llegada());
        dto.setHora_llegada(vuelo.getHora_llegada());
        dto.setHoras_mes(vuelo.getHoras_mes());
        dto.setHoras_año(vuelo.getHoras_año());
        dto.setHoras_totales(vuelo.getHoras_totales());
        dto.setAnticipo(vuelo.getAnticipo());
        dto.setLiquido(vuelo.getLiquido());
        dto.setGasolina(vuelo.getGasolina());
        dto.setHotel(vuelo.getHotel());
        return dto;
    }

    private Localizacion convertToEntity(VueloDTO dto) {
        Localizacion vuelo = new Localizacion();
        vuelo.setOrigen(dto.getOrigen());
        vuelo.setDestino(dto.getDestino());
        vuelo.setFecha(dto.getFecha());
        vuelo.setDuracion(dto.getDuracion());
        vuelo.setMercancia(dto.getMercancia());
        vuelo.setModelo(dto.getModelo());
        vuelo.setUbi_salida(dto.getUbi_salida());
        vuelo.setHora_salida(dto.getHora_salida());
        vuelo.setUbi_llegada(dto.getUbi_llegada());
        vuelo.setHora_llegada(dto.getHora_llegada());
        vuelo.setHoras_mes(dto.getHoras_mes());
        vuelo.setHoras_año(dto.getHoras_año());
        vuelo.setHoras_totales(dto.getHoras_totales());
        vuelo.setAnticipo(dto.getAnticipo());
        vuelo.setLiquido(dto.getLiquido());
        vuelo.setGasolina(dto.getGasolina());
        vuelo.setHotel(dto.getHotel());
        return vuelo;
    }
}