package com.example.demo.mapper.MisionMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.MisionDTO;
import com.example.demo.model.Mision;

@Component
public class MisionMapperImpl implements MisionMapper {

    @Override
    public MisionDTO toDTO(Mision mision) {
        if (mision == null) {
            return null;
        }
        MisionDTO dto = new MisionDTO();
        dto.setId(mision.getId());
        dto.setNombre(mision.getNombre());
        // otros campos
        return dto;
    }

    @Override
    public Mision toEntity(MisionDTO dto) {
        if (dto == null) {
            return null;
        }
        Mision mision = new Mision();
        mision.setId(dto.getId());
        mision.setNombre(dto.getNombre());
        // otros campos
        return mision;
    }

    @Override
    public List<MisionDTO> toListDTO(List<Mision> misiones) {
        List<MisionDTO> result = new ArrayList<>();
        if (misiones != null) {
            for (Mision m : misiones) {
                result.add(toDTO(m));
            }
        }
        return result;
    }
}
