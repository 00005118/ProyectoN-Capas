package com.example.city_security.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "historial_entradas")
public class Historial_entradas {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String fechaCasa;
    private String hora_hora;

    //Llave de role
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "peticiones_id", referencedColumnName = "id")
    private Peticiones peticiones;

}
