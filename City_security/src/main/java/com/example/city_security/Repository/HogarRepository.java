package com.example.city_security.Repository;

import com.example.city_security.models.entities.Hogar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HogarRepository extends JpaRepository<Hogar, UUID> {
    Hogar findByDireccion(String direccion);
}
