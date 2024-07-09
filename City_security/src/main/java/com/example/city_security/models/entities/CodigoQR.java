package com.example.city_security.models.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "codigoQR")
public class CodigoQR {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Date tiempo;
    private String estado;


    //Llave de role-> se creara otro campo llamado role relacionado con tabla Role
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
