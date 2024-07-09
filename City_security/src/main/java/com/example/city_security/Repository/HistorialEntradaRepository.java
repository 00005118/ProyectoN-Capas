package com.example.city_security.Repository;

import com.example.city_security.models.entities.Historial_entradas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface HistorialEntradaRepository extends JpaRepository<Historial_entradas, UUID>{
   // List<Historial_entradas> findByFechaCasaBetween(LocalDate fechaInicio, LocalDate fechaFin);  // Cambia a findByFechaCasaBetween
}
