package com.example.city_security.services;

import com.example.city_security.models.dtos.CreateHistorialEntradaDTO;
import com.example.city_security.models.dtos.HistorialEntradasbetwentDTO;
import com.example.city_security.models.entities.Historial_entradas;

import java.util.List;

public interface HistorialEntradaService {
    void registerHistorialEntrada(CreateHistorialEntradaDTO historialEntradaDTO);
    List<Historial_entradas> findAll();
    List<Historial_entradas> findHistorialEntradaByFecha(HistorialEntradasbetwentDTO fechas);
}
