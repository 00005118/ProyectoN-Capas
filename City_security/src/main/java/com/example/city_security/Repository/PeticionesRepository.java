package com.example.city_security.Repository;

import com.example.city_security.models.entities.Peticiones;
import com.example.city_security.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PeticionesRepository extends JpaRepository<Peticiones, UUID> {
    List<Peticiones> findByUser(User user);

}
