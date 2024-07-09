package com.example.city_security.services.serviceImpl;

import com.example.city_security.Repository.TiposRepository;
import com.example.city_security.models.dtos.CreateTipoDTO;
import com.example.city_security.models.dtos.FindTiposDTO;
import com.example.city_security.models.entities.Tipos;
import com.example.city_security.services.TiposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiposServiceImpl implements TiposService {
    @Autowired
    private TiposRepository tiposRepository;
    @Override
    public void registerTipo(CreateTipoDTO tipo) {
        System.out.println("Registrando tipo es: "+ tipo);
        Tipos tipos = new Tipos();
        tipos.setTipo(tipo.getTipo());
        tiposRepository.save(tipos);

    }

    @Override
    public List<Tipos> findAll() {
        return tiposRepository.findAll();
    }

    @Override
    public Tipos findTipoByTipo(String info) {
        return tiposRepository.findByTipo(info);
    }
}
