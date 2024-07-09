package com.example.city_security.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "tipos")
public class Tipos {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String tipo;

    //llave de peticiones
    @OneToMany(mappedBy = "tipos", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Peticiones> peticiones;

}
