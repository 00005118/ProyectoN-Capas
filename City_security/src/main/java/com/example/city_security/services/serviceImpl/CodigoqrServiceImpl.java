package com.example.city_security.services.serviceImpl;

import com.example.city_security.Repository.CodigoQrRepository;
import com.example.city_security.models.dtos.RegisterCodeQRDTO;
import com.example.city_security.models.entities.CodigoQR;
import com.example.city_security.services.CodigoqrService;
import com.example.city_security.services.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CodigoqrServiceImpl implements CodigoqrService {
    @Autowired
    private Userservice userservice;
    @Autowired
    private CodigoQrRepository codigoqrRepository;

    @Override
    public void registerCodeQR(RegisterCodeQRDTO codeQRRegisterDTO) {
        CodigoQR codigoQR = new CodigoQR();
        codigoQR.setEstado("ACTIVO");
        codigoQR.setTiempo(codeQRRegisterDTO.getTiempo());
        codigoQR.setUser(userservice.findUserByCorreo(codeQRRegisterDTO.getCorreo()));

        codigoqrRepository.save(codigoQR);

    }

    @Override
    public List<CodigoQR> findAll() {
        return codigoqrRepository.findAll();
    }
}
