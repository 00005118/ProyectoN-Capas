package com.example.city_security.services;

import com.example.city_security.models.dtos.CreateTipoDTO;
import com.example.city_security.models.dtos.FindTiposDTO;
import com.example.city_security.models.entities.Tipos;

import java.util.List;

public interface TiposService {
    void registerTipo(CreateTipoDTO tipo);
    List<Tipos> findAll();
    Tipos findTipoByTipo(String info);
}
