package com.example.city_security.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateHogarDTO {
    private String direccion;
    private String telefono;
}
