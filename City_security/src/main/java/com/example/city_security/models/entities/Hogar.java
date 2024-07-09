package com.example.city_security.models.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "hogares")
public class Hogar {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String direccion;
    private String telefono;
}
