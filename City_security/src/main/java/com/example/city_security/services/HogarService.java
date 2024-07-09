package com.example.city_security.services;

import com.example.city_security.models.dtos.CreateHogarDTO;
import com.example.city_security.models.entities.Hogar;

import java.util.List;

public interface HogarService {
    void registerHogar(CreateHogarDTO hogarRegisterDTO);

    List<Hogar> findAll();

}
