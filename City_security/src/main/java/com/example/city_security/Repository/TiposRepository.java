package com.example.city_security.Repository;

import com.example.city_security.models.entities.Tipos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TiposRepository extends JpaRepository<Tipos, UUID> {
    Tipos findByTipo(String tipo);
}
