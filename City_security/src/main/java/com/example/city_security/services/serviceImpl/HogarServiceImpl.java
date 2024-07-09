package com.example.city_security.services.serviceImpl;

import com.example.city_security.Repository.HogarRepository;
import com.example.city_security.models.dtos.CreateHogarDTO;
import com.example.city_security.models.entities.Hogar;
import com.example.city_security.services.HogarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HogarServiceImpl implements HogarService {

    @Autowired
    private HogarRepository hogarRepository;
    @Override
    public void registerHogar(CreateHogarDTO hogarRegisterDTO) {
        Hogar hogar = new Hogar();
        hogar.setDireccion(hogarRegisterDTO.getDireccion());
        hogar.setTelefono(hogarRegisterDTO.getTelefono());

        hogarRepository.save(hogar);
    }

    @Override
    public List<Hogar> findAll() {
        return null;
    }
}
