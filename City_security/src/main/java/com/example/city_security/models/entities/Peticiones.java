package com.example.city_security.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "peticiones")
public class Peticiones {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Date fecha_entrada;
    private Date fecha_salida;
    private String DUI_visitante;
    private String estado;
    private String nombre_visitante;


    //Llave de tipos
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_id", referencedColumnName = "id")
    private Tipos tipos;

    //Llave de historial_entradas
    @OneToMany(mappedBy = "peticiones", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Historial_entradas> historial_entradas;

    //Llave de usuario
    //Llave de tipos
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


}
