package com.example.city_security.services.serviceImpl;

import com.example.city_security.Repository.PeticionesRepository;
import com.example.city_security.models.dtos.CreatePeticionDTO;
import com.example.city_security.models.dtos.FindPeticionByIdDTO;
import com.example.city_security.models.dtos.FindPeticionDTO;
import com.example.city_security.models.dtos.UpdatePeticionDTO;
import com.example.city_security.models.entities.Peticiones;
import com.example.city_security.services.PeticionesService;
import com.example.city_security.services.Userservice;
import com.example.city_security.services.TiposService;
import com.example.city_security.models.entities.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PeticionesServiceImpl implements PeticionesService {
    @Autowired
    private TiposService tiposService;
    @Autowired
    private PeticionesRepository peticionesRepository;
    @Autowired
    private Userservice userService;

    @Override
    public void registerPeticion(CreatePeticionDTO peticionRegisterDTO) {
        Peticiones peticion = new Peticiones();
        peticion.setFecha_entrada(peticionRegisterDTO.getFecha_entrada());
        peticion.setFecha_salida(peticionRegisterDTO.getFecha_salida());
        peticion.setDUI_visitante(peticionRegisterDTO.getDui_visitante());
        peticion.setEstado(peticionRegisterDTO.getEstado());
        peticion.setNombre_visitante(peticionRegisterDTO.getNombre_visitante());

        //Insertando el usuario de tipo usuario y el tipo
        peticion.setTipos(tiposService.findTipoByTipo(peticionRegisterDTO.getTipo_peticion()));
        peticion.setUser(userService.findUserByCorreo(peticionRegisterDTO.getCorreo()));

        peticionesRepository.save(peticion);
    }

    @Override
    public List<Peticiones> findAll() {
        return peticionesRepository.findAll();
    }

    @Override
    public List<Peticiones> findByPeticionbycorreo(FindPeticionDTO info) {
        User user = userService.findUserByCorreo(info.getCorreo());
        if (user == null) {
            throw new EntityNotFoundException("User not found with correo: " + info.getCorreo());
        }
        return peticionesRepository.findByUser(user);

    }

    @Override
    public void updatePeticionStatus(UpdatePeticionDTO estado) {
        Peticiones peticion = peticionesRepository.findById(estado.getCode())
                .orElseThrow(() -> new EntityNotFoundException("Peticion not found with id: " + estado.getCode()));
        System.out.println("El registro de esta cosa es: " + estado);
        peticion.setEstado(estado.getEstado());
        peticionesRepository.save(peticion);
    }

    @Override
    public Peticiones findById(UUID id) {
        Peticiones peticion = peticionesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Peticion not found with id: " + id));

        return peticion;
    }


}
