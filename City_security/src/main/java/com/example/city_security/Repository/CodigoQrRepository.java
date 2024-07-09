package com.example.city_security.Repository;

import com.example.city_security.models.entities.CodigoQR;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CodigoQrRepository extends JpaRepository<CodigoQR, UUID> {
}
