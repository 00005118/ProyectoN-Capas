package com.example.city_security.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterCodeQRDTO {
    private Date tiempo;
    private String correo;
}
