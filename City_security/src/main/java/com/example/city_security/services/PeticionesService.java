package com.example.city_security.services;

import com.example.city_security.models.dtos.CreatePeticionDTO;
import com.example.city_security.models.dtos.FindPeticionByIdDTO;
import com.example.city_security.models.dtos.FindPeticionDTO;
import com.example.city_security.models.dtos.UpdatePeticionDTO;
import com.example.city_security.models.entities.Peticiones;

import java.util.List;
import java.util.UUID;

public interface PeticionesService {
    void registerPeticion(CreatePeticionDTO peticionRegisterDTO);

    List<Peticiones> findAll();

    List<Peticiones> findByPeticionbycorreo(FindPeticionDTO correo);
    void updatePeticionStatus(UpdatePeticionDTO status);
    Peticiones findById(UUID id);
}
