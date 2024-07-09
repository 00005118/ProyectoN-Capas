package com.example.city_security.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HistorialEntradasbetwentDTO {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
