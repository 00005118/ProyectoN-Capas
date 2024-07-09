package com.example.city_security.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateHistorialEntradaDTO {
    private String fecha_casa;
    private String hora_hora;
    private UUID peticiones_id;
}
