package com.example.demo.services;

import com.example.demo.model.Mision;
import com.example.demo.repository.MisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MisionService {

    @Autowired
    private MisionRepository misionRepository;

    public List<Mision> getAll() {
        return misionRepository.findAll();
    }

    public Mision getById(Long id) {
        return misionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Misión no encontrada con id: " + id));
    }

    public Mision create(Mision mision) {
        return misionRepository.save(mision);
    }

    public Mision update(Mision mision) {
        if (!misionRepository.existsById(mision.getId())) {
            throw new RuntimeException("Misión no encontrada con id: " + mision.getId());
        }
        return misionRepository.save(mision);
    }

    public void delete(Long id) {
        misionRepository.deleteById(id);
    }
}
