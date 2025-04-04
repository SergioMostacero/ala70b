package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UbicacionRepository;

@Service
public class UbicacionService {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    
}