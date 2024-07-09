package com.example.city_security.services.serviceImpl;

import com.example.city_security.Repository.HistorialEntradaRepository;
import com.example.city_security.models.dtos.CreateHistorialEntradaDTO;
import com.example.city_security.models.dtos.HistorialEntradasbetwentDTO;
import com.example.city_security.models.entities.Historial_entradas;
import com.example.city_security.services.HistorialEntradaService;
import com.example.city_security.services.PeticionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HistorialEntradasServiceImpl implements HistorialEntradaService {
    @Autowired
    private HistorialEntradaRepository historialEntradaRepository;
    @Autowired
    private PeticionesService peticionesService;

    @Override
    public void registerHistorialEntrada(CreateHistorialEntradaDTO historialEntradaDTO) {
        Historial_entradas historial_entradas = new Historial_entradas();
        historial_entradas.setFechaCasa(historialEntradaDTO.getFecha_casa());
        historial_entradas.setHora_hora(historialEntradaDTO.getHora_hora());
        historial_entradas.setPeticiones(peticionesService.findById(historialEntradaDTO.getPeticiones_id()));

        historialEntradaRepository.save(historial_entradas);
    }

    @Override
    public List<Historial_entradas> findAll() {
        return historialEntradaRepository.findAll();
    }

    @Override
    public List<Historial_entradas> findHistorialEntradaByFecha(HistorialEntradasbetwentDTO fechas) {
        return null;
    }
}
