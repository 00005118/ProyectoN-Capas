package com.example.city_security.controllers;

import com.example.city_security.models.dtos.CreateHistorialEntradaDTO;
import com.example.city_security.models.dtos.HistorialEntradasbetwentDTO;
import com.example.city_security.models.entities.Historial_entradas;
import com.example.city_security.services.HistorialEntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historial-entrada")
public class HistorialEntradaController {
    @Autowired
    private HistorialEntradaService historialEntradaService;

    @PostMapping("/register-historial-entrada")
    public ResponseEntity<?> addHistorialEntrada(@RequestBody CreateHistorialEntradaDTO historialEntradaDTO) {
        historialEntradaService.registerHistorialEntrada(historialEntradaDTO);
        return ResponseEntity.ok("Historial de entrada registrado");
    }
    @GetMapping("/all-historial-entradas")
    public List<Historial_entradas> getAllHistorialEntradas() {
        return historialEntradaService.findAll();
    }

    @PostMapping("/between-dates")
    public ResponseEntity<List<Historial_entradas>> getHistorialEntradasBetweenDates(@RequestBody HistorialEntradasbetwentDTO fechas) {
        List<Historial_entradas> historialEntradas = historialEntradaService.findHistorialEntradaByFecha(fechas);
        if (historialEntradas.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(historialEntradas);
        }
    }
}
